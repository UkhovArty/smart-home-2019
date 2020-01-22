package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

import java.util.Collection;

public class SensorEventAdapter implements EventConverter {
    private Collection<EventConverter> ccEventConverters;

    public SensorEventAdapter(Collection<EventConverter> ccEventConverters) {
        this.ccEventConverters = ccEventConverters;
    }

    @Override
    public SensorEvent convert(CCSensorEvent event){
        for (EventConverter ccEventConverter : ccEventConverters) {
            SensorEvent adaptedEvent = ccEventConverter.convert(event);
            if (adaptedEvent != null) {
                return adaptedEvent;
            }
        }

        return null;
    }
}
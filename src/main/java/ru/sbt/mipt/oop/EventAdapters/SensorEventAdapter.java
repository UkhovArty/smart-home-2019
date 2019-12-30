package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.CCSensorEvent;

import java.util.Collection;

public class SensorEventAdapter implements EventAdapter {
    private Collection<EventAdapter> ccEventAdapters;

    public SensorEventAdapter(Collection<EventAdapter> ccEventAdapters) {
        this.ccEventAdapters = ccEventAdapters;
    }

    @Override
    public SensorEvent adaptee(CCSensorEvent event){
        for (EventAdapter ccEventAdapter : ccEventAdapters) {
            SensorEvent adaptedEvent = ccEventAdapter.adaptee(event);
            if (adaptedEvent != null) {
                return adaptedEvent;
            }
        }

        return null;
    }
}
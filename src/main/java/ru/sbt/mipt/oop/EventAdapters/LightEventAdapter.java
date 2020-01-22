package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.SensorEvents.LightSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class LightEventAdapter implements EventConverter {
    @Override
    public SensorEvent convert(CCSensorEvent event) {
        if (!(event.getEventType().equals("LightIsOn")) &&
                !(event.getEventType().equals("LightIsOff"))) {
            return null;
        }

        if (event.getEventType().equals("LightIsOn")) {
            return new LightSensorEvent(SensorEventType.LIGHT_ON, event.getObjectId());
        } else {
            return new LightSensorEvent(SensorEventType.LIGHT_OFF, event.getObjectId());
        }
    }
}
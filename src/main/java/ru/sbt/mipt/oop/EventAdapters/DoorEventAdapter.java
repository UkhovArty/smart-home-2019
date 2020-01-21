package ru.sbt.mipt.oop.EventAdapters;


import ru.sbt.mipt.oop.SensorEvents.DoorSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class DoorEventAdapter implements EventAdapter {
    @Override
    public SensorEvent adaptee(CCSensorEvent event) {
        if (!(event.getEventType().equals("DoorIsOpen")) &&
                !(event.getEventType().equals("DoorIsClosed"))) {
            return null;
        }

        if (event.getEventType().equals("DoorIsOpen")) {
            return new DoorSensorEvent(SensorEventType.DOOR_OPEN, event.getObjectId());
        } else {
            return new DoorSensorEvent(SensorEventType.DOOR_CLOSED, event.getObjectId());
        }
    }
}

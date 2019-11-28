package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.*;

public class NewEventGetter implements EventInput {

    @Override
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) {
            return null; // null means end of event stream;
        } else if (Math.random() < 0.35) {
            String objectId = "" + ((int) (10 * Math.random()));
            return new LightSensorEvent((Math.random() < 0.5) ? SensorEventType.LIGHT_OFF : SensorEventType.LIGHT_ON , objectId);
        } else if (Math.random() < 0.7) {
            String objectId = "" + ((int) (10 * Math.random()));
            return new DoorSensorEvent((Math.random() < 0.5) ? SensorEventType.DOOR_CLOSED : SensorEventType.DOOR_OPEN, objectId);
        } else {
            String objectId = "1";
            String code = (Math.random() < 0.95) ? "rightPassword" : "wrongPassword";
            return  new AlarmSensorEvent(((Math.random() < 0.5) ? SensorEventType.ALARM_ACTIVATE : SensorEventType.ALARM_DEACTIVATE), objectId, code);
        }
    }
}
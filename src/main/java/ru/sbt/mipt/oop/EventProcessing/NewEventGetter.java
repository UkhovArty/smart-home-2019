package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public class NewEventGetter {
    public static SensorEvent getNextSensorEvent(SmartHome smartHome) {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId, smartHome);
    }
}

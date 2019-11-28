package ru.sbt.mipt.oop.SensorEvents;

public class LightSensorEvent extends SensorEvent {

    public LightSensorEvent(SensorEventType type, String objectId) {
        super(type, objectId);
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

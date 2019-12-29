package ru.sbt.mipt.oop.SensorEvents;

public class DoorSensorEvent extends SensorEvent {

    public DoorSensorEvent(SensorEventType type, String objectId) {
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

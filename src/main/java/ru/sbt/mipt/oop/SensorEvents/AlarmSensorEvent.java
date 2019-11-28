package ru.sbt.mipt.oop.SensorEvents;


import ru.sbt.mipt.oop.AlarmSystemSecretPackage.AlarmSystem;

public class AlarmSensorEvent extends SensorEvent {
    private final String code;
    public AlarmSensorEvent(SensorEventType type, String objectId, String code) {
        super(type, objectId);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

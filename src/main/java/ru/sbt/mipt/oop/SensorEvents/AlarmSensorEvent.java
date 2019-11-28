package ru.sbt.mipt.oop.SensorEvents;


import ru.sbt.mipt.oop.AlarmSystemSecretPackage.AlarmSystem;

public class AlarmSensorEvent extends SensorEvent {
    private final String code;
    private final AlarmSystem state;
    public AlarmSensorEvent(SensorEventType type, String objectId, String code, AlarmSystem state) {
        super(type, objectId);
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public AlarmSystem getState() {
        return state;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

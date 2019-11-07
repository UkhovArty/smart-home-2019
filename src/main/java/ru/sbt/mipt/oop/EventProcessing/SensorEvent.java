package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private final SmartHome smartHome;

    public SensorEvent(SensorEventType type, String objectId, SmartHome smartHome) {
        this.type = type;
        this.objectId = objectId;
        this.smartHome = smartHome;
    }

    public  SmartHome getSmartHome (){
        return smartHome;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

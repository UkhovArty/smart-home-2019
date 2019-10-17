package ru.sbt.mipt.oop;

public interface EventHandler {
    public void handleEvent(Room room, SensorEvent event, SmartHome smartHome);
}

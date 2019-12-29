package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public interface EventInput {
    public SensorEvent getNextSensorEvent();
}
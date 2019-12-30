package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.CCSensorEvent;

public interface EventAdapter {
    SensorEvent adaptee(CCSensorEvent event);
}
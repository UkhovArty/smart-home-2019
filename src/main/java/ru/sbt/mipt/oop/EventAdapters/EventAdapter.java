package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

public interface EventAdapter {
    SensorEvent adaptee(CCSensorEvent event);
}
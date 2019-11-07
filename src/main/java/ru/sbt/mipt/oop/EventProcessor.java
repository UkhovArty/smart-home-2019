package ru.sbt.mipt.oop;

import java.util.List;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventProcessor {
    private final List<EventHandler> handlers;
    public EventProcessor (List<EventHandler> handlers) {
        this.handlers = handlers;
    }
    public void processEvent(SensorEvent event) {
        for (EventHandler handler: handlers) {
            handler.handleEvent(event);
        }
    }
}

package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

import java.util.List;

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
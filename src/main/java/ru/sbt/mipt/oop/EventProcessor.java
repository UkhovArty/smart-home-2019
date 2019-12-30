package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventAdapters.EventAdapter;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.CCSensorEvent;

import java.util.List;

public class EventProcessor {
    private final List<EventHandler> handlers;
    private EventAdapter adapter;
    public EventProcessor (List<EventHandler> handlers, EventAdapter adapter) {
        this.handlers = handlers;
        this.adapter = adapter;
    }
    public void processEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " " + event.getObjectId());
        SensorEvent AdapEvent = adapter.adaptee(event);

        for (EventHandler handler: handlers) {
            handler.handleEvent(AdapEvent);
        }
    }
}
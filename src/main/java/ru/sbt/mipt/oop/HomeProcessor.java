package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class HomeProcessor {
    private final EventHandler eventHandler;

    public HomeProcessor(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void run() {
        // начинаем цикл обработки событий
        EventInput eventInput = new NewEventGetter();
        SensorEvent event = eventInput.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            eventHandler.handleEvent(event);
            event = eventInput.getNextSensorEvent();
        }
    }
}
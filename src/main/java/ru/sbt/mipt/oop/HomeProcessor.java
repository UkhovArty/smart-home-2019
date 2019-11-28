package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class HomeProcessor {
    private final EventProcessor eventProcessor;

    public HomeProcessor(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    public void run() {
        // начинаем цикл обработки событий
        EventInput eventInput = new NewEventGetter();
        SensorEvent event = eventInput.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            eventProcessor.processEvent(event);
            event = eventInput.getNextSensorEvent();
        }
    }
}
package ru.sbt.mipt.oop;

public class HomeProcessor {
    private final EventProcessor eventProcessor;

    public HomeProcessor(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    public void run() {
        // начинаем цикл обработки событий
        SensorEvent event = NewEventGetter.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            eventProcessor.processEvent(event);
            event = NewEventGetter.getNextSensorEvent();
        }
    }
}

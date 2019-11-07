package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public class EventProcessor {
    public static void eventProcessing(SensorEvent event, SmartHome smartHome) {
        while (event != null) {
            System.out.println("Got event: " + event);
            smartHome.execute(event, smartHome);
            event = NewEventGetter.getNextSensorEvent(smartHome);
        }
    }
}

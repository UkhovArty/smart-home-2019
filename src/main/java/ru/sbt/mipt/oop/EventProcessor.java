package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventProcessor {
    static void eventProcessing(SensorEvent event, SmartHome smartHome) {
        while (event != null) {
            System.out.println("Got event: " + event);
            smartHome.execute(event, smartHome);
            event = NewEventGetter.getNextSensorEvent();
        }
    }
}

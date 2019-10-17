package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventProcessor {
    static void eventProcessing(SensorEvent event, SmartHome smartHome) {
        while (event != null) {
            System.out.println("Got event: " + event);
            for (Room room : smartHome.getRooms()) {
                EventHandler handle = new LightEventHandler();
                handle.handleEvent(room, event, smartHome);
                EventHandler handle1 = new DoorEventHandler();
                handle1.handleEvent(room, event, smartHome);
            }
            event = NewEventGetter.getNextSensorEvent();
        }
    }
}

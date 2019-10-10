package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventIdentificator {
    private static int identificator;

    static int eventTypeIdentifier(SensorEvent event) {
        if ((event.getType() == LIGHT_ON) || event.getType() == LIGHT_OFF) {
            identificator = 0;
        }
        if ((event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)) {
            identificator = 1;
        }
        return identificator;
    }
}

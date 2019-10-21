package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    @Override
    public void handleEvent(Room room, SensorEvent event, SmartHome smartHome) {
        smartHome.execute(event, room);
    }


}


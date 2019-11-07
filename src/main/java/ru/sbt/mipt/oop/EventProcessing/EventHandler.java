package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.CollectionSmarthome.Room;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public interface EventHandler {
    public void handleEvent(Room room, SensorEvent event, SmartHome smartHome);
}

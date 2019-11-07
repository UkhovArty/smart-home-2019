package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.CollectionSmarthome.Room;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public class LightEventHandler implements EventHandler {
    @Override
    public void handleEvent(Room room, SensorEvent event, SmartHome smarthome) {
       smarthome.execute(event, smarthome);
    }
}

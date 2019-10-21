package ru.sbt.mipt.oop;

public class LightEventHandler implements EventHandler {
    @Override
    public void handleEvent(Room room, SensorEvent event, SmartHome smarthome) {
       smarthome.execute(event, smarthome);
    }
}

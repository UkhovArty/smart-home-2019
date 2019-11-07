package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventHandler implements EventHandler {
    private SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Light lightFromEvent = getDevice(event);
        if (lightFromEvent == null) return;
        switch (event.getType()) {
            case LIGHT_ON:
                lightFromEvent.setOn(true);
                System.out.println("Light " + lightFromEvent.getId() + " was turned on.");
                break;
            case LIGHT_OFF:
                lightFromEvent.setOn(false);
                System.out.println("Door " + lightFromEvent.getId() + " was closed.");
                break;
        }
    }

    private Light getDevice(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    System.out.print("room " + room.getName() + ":");
                    return light;
                }
            }
        }
        return null;
    }
}


package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventHandler implements EventHandler {
    private SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Devise deviseFromEvent = getDevice(event);
        if (deviseFromEvent == null) return;
        switch (event.getType()) {
            case LIGHT_ON:
                ((Light) deviseFromEvent).setOn(true);
                System.out.println("Light " + deviseFromEvent.getId() + " was turned on.");
                break;
            case LIGHT_OFF:
                ((Light) deviseFromEvent).setOn(false);
                System.out.println("Door " + deviseFromEvent.getId() + " was closed.");
                break;
        }
    }

    private Devise getDevice(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Devise device : room.getDevices()) {
                if (device.getId().equals(event.getObjectId())) {
                    if (device.getType().equals("light")) {
                        System.out.print("room " + room.getName() + ":");
                        return device;
                    }
                }
            }
        }
        return null;
    }
}


package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Devise deviseFromEvent = getDevice(event);
        if (deviseFromEvent == null) return;
        switch (event.getType()) {
            case DOOR_OPEN:
                ((Door) deviseFromEvent).setOpen(true);
                System.out.println("Door " + deviseFromEvent.getId() + " was opened.");
                break;
            case DOOR_CLOSED:
                ((Door) deviseFromEvent).setOpen(false);
                System.out.println("Door " + deviseFromEvent.getId() + " was closed.");
                break;
        }

    }

    private Devise getDevice(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Devise device : room.getDevices()) {
                if (device.getId().equals(event.getObjectId())) {
                    if (device.getType().equals("door")) {
                        System.out.print("room " + room.getName() + ":");
                        return device;
                    }
                }
            }
        }
        return null;
    }
}


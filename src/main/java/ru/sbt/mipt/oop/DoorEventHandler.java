package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Door doorFromEvent = getDevice(event);
        if (doorFromEvent == null) return;
        switch (event.getType()) {
            case DOOR_OPEN:
                doorFromEvent.setOpen(true);
                System.out.println("Door " + doorFromEvent.getId() + " was opened.");
                break;
            case DOOR_CLOSED:
                doorFromEvent.setOpen(false);
                System.out.println("Door " + doorFromEvent.getId() + " was closed.");
                break;
        }

    }

    private Door getDevice(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    System.out.print("room " + room.getName() + ":");
                    return door;
                }
            }
        }
        return null;
    }
}


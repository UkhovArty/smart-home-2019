package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    switch (event.getType()) {
                        case DOOR_OPEN:
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() +" in room " + room.getName() + " was opened.");
                            break;
                        case DOOR_CLOSED:
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                            break;
                        default:
                    }
                }
            }
        }
    }
}
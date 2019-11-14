package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Action action;
        if (event.getType() != SensorEventType.DOOR_CLOSED && event.getType() != SensorEventType.DOOR_OPEN) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Door)) {
                    return;
                }
                Door door = (Door) o;
                if (door.getId().equals(event.getObjectId())) {
                    switch (event.getType()) {
                        case DOOR_OPEN:
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room "  + " was opened.");
                            break;
                        case DOOR_CLOSED:
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + " was closed.");
                            break;
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
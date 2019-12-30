package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;

public class HallDoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event == null) {
            return;
        }
        Action action;
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Door)) {
                    return;
                }
                Door door = (Door) o;
                if (door.getId().equals(event.getObjectId()) && door.getType().equals("door")) {
                    if (door.getRoomName().equals("Hall")) {
                        AllLightsSwitcher();
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }

    private void AllLightsSwitcher() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setSwitchState(false);
            }
        }
        System.out.println("All lights were switched off");
    }
}
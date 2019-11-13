package ru.sbt.mipt.oop;

public class HallDoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            return;
        } else {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId()) && door.getType().equals("door")) {
                        if (room.getName().equals("Hall")) {
                            AllLightsSwitcher();
                        }
                    }
                }
            }
        }
    }

    private void AllLightsSwitcher() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
            }
        }
        System.out.println("All lights were switched off");
    }
}
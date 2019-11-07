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
                for (Devise device : room.getDevices()) {
                    if (device.getId().equals(event.getObjectId()) && device.getType().equals("door")) {
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
            for (Devise device : room.getDevices()) {
                if (device.getType().equals("light")) {
                    ((Light) device).setOn(false);
                }
            }
        }
    }
}
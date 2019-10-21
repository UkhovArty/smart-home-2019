package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SmartHomeScenarioTypes.HALL_DOOR_WAS_CLOSED;

public class AllLightsSwitcher {
    public static void allLightsOff(SmartHome smartHome, SmartHomeScenarioTypes type) {
        if (type == HALL_DOOR_WAS_CLOSED) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    Sender.sendCommand(command);
                }
            }
        }
    }
}

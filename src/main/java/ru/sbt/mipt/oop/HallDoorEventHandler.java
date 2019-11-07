package ru.sbt.mipt.oop;

public class HallDoorEventHandler {
     if (room.getName().equals("hall")) {
        SmartHomeScenarioTypes type = SmartHomeScenarioTypes.HALL_DOOR_WAS_CLOSED;
        SmartHomeScenarioProcessor.processScenario(smartHome, type);
    }
}

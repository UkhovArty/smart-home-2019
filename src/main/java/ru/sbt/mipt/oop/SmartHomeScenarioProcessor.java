package ru.sbt.mipt.oop;

public class SmartHomeScenarioProcessor {

    public static void processScenario(SmartHome smartHome, SmartHomeScenarioTypes type) {
        AllLightsSwitcher.allLightsOff(smartHome, type);
    }
}

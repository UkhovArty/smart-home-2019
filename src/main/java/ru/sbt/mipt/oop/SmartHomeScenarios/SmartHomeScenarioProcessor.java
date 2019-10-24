package ru.sbt.mipt.oop.SmartHomeScenarios;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public class SmartHomeScenarioProcessor {

    public static void processScenario(SmartHome smartHome, SmartHomeScenarioTypes type) {
        AllLightsSwitcher.allLightsOff(smartHome, type);
    }
}

package ru.sbt.mipt.oop.EventProcessing;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.AlarmSystemContext;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;
import ru.sbt.mipt.oop.SmartHomeScenarios.AllLightsOscillator;

public class AlarmEventHandler {
    public void HandleAlarmEvent (AlarmSystemContext context, SensorEvent event, SmartHome smartHome) {
        switch (event.getType()) {
            case ALARM_ACTIVATED:
                AllLightsOscillator.OscillateAllLights(context, smartHome);
        }
    }
}

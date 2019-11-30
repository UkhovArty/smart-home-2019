package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.ActivatedState;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.Alarm;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.DeactivatedState;
import ru.sbt.mipt.oop.SensorEvents.AlarmSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Scanner;

public class AlarmEventHandler implements EventHandler {

    private SmartHome smartHome;

    public AlarmEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Action action;
        if (event.getType() != SensorEventType.ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Alarm)) {
                    return;
                }
                Alarm alarm = (Alarm) o;
                AlarmSensorEvent alarmEvent = (AlarmSensorEvent) event;
                switch (event.getType()) {
                    case ALARM_ACTIVATE:
                        alarm.setState(new ActivatedState(alarm));
                        System.out.println("Alarm activated");
                        break;
                    case ALARM_DEACTIVATE:
                        alarm.setState(new DeactivatedState(alarm));
                        System.out.println("Alarm deactivated");
                        break;
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
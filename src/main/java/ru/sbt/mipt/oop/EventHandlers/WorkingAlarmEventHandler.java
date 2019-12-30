package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.*;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;
import ru.sbt.mipt.oop.SignalSendingSystem;
import ru.sbt.mipt.oop.library.CCSensorEvent;
import ru.sbt.mipt.oop.library.EventHandler;

public class WorkingAlarmEventHandler implements EventHandler {
    private final Alarm alarm;
    private final EventProcessor eventProcessor;
    private final SignalSendingSystem signalSender;

    public WorkingAlarmEventHandler(Alarm alarm, EventProcessor eventProcessor, SignalSendingSystem signalSender) {
        this.alarm = alarm;
        this.eventProcessor = eventProcessor;
        this.signalSender = signalSender;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        if (event == null) {
            return;
        }
        AlarmSystem state = alarm.getState();
        if (state instanceof WorkingState) {
            if (event.getEventType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                eventProcessor.processEvent(event);
            } else {
                signalSender.sendSignal("Alarm is in process, all systems are blocked");
            }
        }
        if (state instanceof ActivatedState) {
            if (event.getEventType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                eventProcessor.processEvent(event);
            } else {
                alarm.WorkingState();
            }
        }
        if (state instanceof DeactivatedState) {
            eventProcessor.processEvent(event);
        }
    }
}

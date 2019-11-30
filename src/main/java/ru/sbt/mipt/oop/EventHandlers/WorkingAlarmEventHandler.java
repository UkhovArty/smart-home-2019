package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.*;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SignalSendingSystem;

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
    public void handleEvent(SensorEvent event) {
        AlarmSystem state = alarm.getState();
        if (state instanceof WorkingState || state instanceof ActivatedState) {
            signalSender.sendSignal("Alarm is in process, all systems are blocked");
        }
        if (state instanceof ActivatedState) {
            eventProcessor.processEvent(event);
        }
        if (state instanceof DeactivatedState) {
            eventProcessor.processEvent(event);
        }
    }
}

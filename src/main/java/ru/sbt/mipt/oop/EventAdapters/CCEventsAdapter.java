package ru.sbt.mipt.oop.EventAdapters;

import ru.sbt.mipt.oop.EventHandlers.WorkingAlarmEventHandler;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SignalSendingSystem;
import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class CCEventsAdapter implements EventHandler{
    private EventConverter eventConverter;
    private ru.sbt.mipt.oop.EventHandlers.EventHandler workingAlarmEventHandler;

    public CCEventsAdapter(EventConverter eventConverter, WorkingAlarmEventHandler workingAlarmEventHandler) {
        this.eventConverter = eventConverter;
        this.workingAlarmEventHandler = workingAlarmEventHandler;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " " + event.getObjectId());
        SensorEvent adaptedEvent = eventConverter.convert(event);
        workingAlarmEventHandler.handleEvent(adaptedEvent);
    }
}

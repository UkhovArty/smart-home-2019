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
    private EventAdapter eventAdapter;
    private SmartHome smartHome;
    private List<ru.sbt.mipt.oop.EventHandlers.EventHandler> handlers;
    private SignalSendingSystem sendingSystem;

    public CCEventsAdapter(EventAdapter eventAdapter, SmartHome smartHome, List<ru.sbt.mipt.oop.EventHandlers.EventHandler> handlers, SignalSendingSystem sendingSystem) {
        this.eventAdapter = eventAdapter;
        this.smartHome = smartHome;
        this.handlers = handlers;
        this.sendingSystem = sendingSystem;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " " + event.getObjectId());
        SensorEvent adaptedEvent = eventAdapter.adaptee(event);
        WorkingAlarmEventHandler workingAlarmEventHandler = new WorkingAlarmEventHandler(smartHome.getAlarm(),new EventProcessor(handlers), sendingSystem);
        workingAlarmEventHandler.handleEvent(adaptedEvent);
    }
}

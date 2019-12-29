package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;

public class LightEventHandler implements EventHandler {
    private SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        Action action;
        if (event.getType() != SensorEventType.LIGHT_ON && event.getType() != SensorEventType.LIGHT_OFF) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Light)) {
                    return;
                }
                Light light = (Light) o;
                if (light.getId().equals(event.getObjectId())) {
                    switch (event.getType()) {
                        case LIGHT_ON:
                            light.setSwitchState(true);
                            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned on.");
                            break;
                        case LIGHT_OFF:
                            light.setSwitchState(false);
                            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned off");
                            break;
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}

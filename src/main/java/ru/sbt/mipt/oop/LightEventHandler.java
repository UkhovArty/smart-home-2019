package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventHandler implements EventHandler {
    private SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    switch (event.getType()) {
                        case LIGHT_ON:
                            light.setSwitchState(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                            break;
                        case LIGHT_OFF:
                            light.setSwitchState(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() +  " was turned off");
                            break;
                    }
                }
            }
        }
    }
}
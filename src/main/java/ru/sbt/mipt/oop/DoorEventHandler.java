package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;
    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void handleEvent(SensorEvent event) {
        for (Devise devise : room.getDoors()) {
            if (devise.getId().equals(event.getObjectId())) {
                switch (event.getType()) {
                    case DOOR_OPEN:
                        ((Door) devise).setOpen(true);
                        System.out.println("Door " + devise.getId() + " in room " + room.getName() + " was opened.");
                        break;
                    case DOOR_CLOSED:
                        ((Door) devise).setOpen(false);
                        System.out.println("Door " + devise.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытии двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        if (room.getName().equals("hall")) {
                            SmartHomeScenarioTypes type = SmartHomeScenarioTypes.HALL_DOOR_WAS_CLOSED;
                            SmartHomeScenarioProcessor.processScenario(smartHome, type);
                        }
                        break;
                }
            }
        }
    }
}

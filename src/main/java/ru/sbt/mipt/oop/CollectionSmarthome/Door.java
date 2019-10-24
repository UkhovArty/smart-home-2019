package ru.sbt.mipt.oop.CollectionSmarthome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.CollectionSmarthome.ComponentOfTheCollection;
import ru.sbt.mipt.oop.EventProcessing.SensorEvent;
import ru.sbt.mipt.oop.SmartHomeScenarios.SmartHomeScenarioProcessor;
import ru.sbt.mipt.oop.SmartHomeScenarios.SmartHomeScenarioTypes;

public class Door implements ComponentOfTheCollection {
    private final String id;
    private boolean isOpen;

    public Door(boolean someAct, String id) {
        this.id = id;
        this.isOpen = someAct;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void execute(SensorEvent event, PartofTheHouse room) {
        if (this.getId().equals(event.getObjectId())) {
            switch (event.getType()) {
                case DOOR_OPEN:
                    this.setOpen(true);
                    System.out.println("Door " + this.getId() + " in room " + room.getName() + " was opened.");
                    break;
                case DOOR_CLOSED:
                    this.setOpen(false);
                    System.out.println("Door " + this.getId() + " in room " + room.getName() + " was closed.");
                    // если мы получили событие о закрытии двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        SmartHomeScenarioTypes type = SmartHomeScenarioTypes.HALL_DOOR_WAS_CLOSED;
                        SmartHomeScenarioProcessor.processScenario(event.getSmartHome(), type);
                    }
                    break;
            }
        }
    }
}

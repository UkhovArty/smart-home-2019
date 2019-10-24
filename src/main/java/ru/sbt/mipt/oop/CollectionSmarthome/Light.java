package ru.sbt.mipt.oop.CollectionSmarthome;

import ru.sbt.mipt.oop.CollectionSmarthome.ComponentOfTheCollection;
import ru.sbt.mipt.oop.PartofTheHouse;
import ru.sbt.mipt.oop.EventProcessing.SensorEvent;

public class Light implements ComponentOfTheCollection {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean someAct) {
        this.isOn = someAct;
        this.id = id;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void execute(SensorEvent event, PartofTheHouse room) {
        if (this.getId().equals(event.getObjectId())) {
            switch (event.getType()) {
                case LIGHT_ON:
                    this.setOn(true);
                    System.out.println("Light " + this.getId() + " in room " + room.getName() + " was turned on.");
                    break;
                case LIGHT_OFF:
                    this.setOn(false);
                    System.out.println("Light " + this.getId() + " in room " + room.getName() + " was turned off.");
                    break;
            }
        }
    }
}

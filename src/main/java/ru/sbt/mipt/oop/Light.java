package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;
    private final String type = "light";

    public Light(String id, boolean someAct) {
        this.isOn = isOn();
        this.id = id;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getType() {
        return "light";
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void execute(Action action) {

    }
}
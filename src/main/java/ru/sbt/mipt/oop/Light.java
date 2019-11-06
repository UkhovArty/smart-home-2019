package ru.sbt.mipt.oop;

public class Light implements Devise{
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

    @Override
    public String getType() {
        return "light";
    }
    @Override
    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

package ru.sbt.mipt.oop;

public class Light extends Devise{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean someAct) {
        super(id, someAct);
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
}

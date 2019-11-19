package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;
    private final String type = "light";
    private final String roomName;

    public Light(String id, boolean isOn, String roomName) {
        this.isOn = isOn;
        this.id = id;
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
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
        action.execute(this);
    }
}
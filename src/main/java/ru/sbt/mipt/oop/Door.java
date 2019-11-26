package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private final String type = "door";
    private final String roomName;

    public Door(boolean isOpen, String id, String roomName) {
        this.isOpen = isOpen;
        this.id = id;
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getType() {
        return "door";
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
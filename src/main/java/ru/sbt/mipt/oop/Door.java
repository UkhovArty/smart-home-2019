package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private final String type = "door";

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
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

    @Override
    public void execute(Action action) {

    }
}
package ru.sbt.mipt.oop;

public class Door {
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
}
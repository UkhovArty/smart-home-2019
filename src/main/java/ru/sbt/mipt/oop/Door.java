package ru.sbt.mipt.oop;

public class Door implements Devise {
    private final String id;
    private boolean isOpen;
    private final String type = "door";

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
    public String getType() {
        return "door";
    }
    @Override
    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}

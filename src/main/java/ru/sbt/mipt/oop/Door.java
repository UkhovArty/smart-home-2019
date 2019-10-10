package ru.sbt.mipt.oop;

public class Door extends Devise {
    private final String id;
    private boolean isOpen;

    public Door(boolean someAct, String id) {
        super(id, someAct);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}

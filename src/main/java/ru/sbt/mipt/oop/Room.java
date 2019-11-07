package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room {
    private Collection<Devise> devices;
    private String name;

    public Room(Collection<Devise> devices, String name) {
        this.devices = devices;
        this.name = name;
    }

    public Collection<Devise> getDevices() {
        return devices;
    }

    public String getName() {
        return name;
    }
}

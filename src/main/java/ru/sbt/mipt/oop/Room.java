package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class Room {
    private Collection<Devise> devices;
    private String name;

    public Room(Collection<Devise> devices, String name) {
        this.devices = devices;
        this.name = name;
    }

    public Room(String name) {
        this(new ArrayList<>(), name);
    }

    public Collection<Devise> getDevices() {
        return devices;
    }

    public void addDevice(Devise device) {
        devices.add(device);
    }

    public String getName() {
        return name;
    }
}

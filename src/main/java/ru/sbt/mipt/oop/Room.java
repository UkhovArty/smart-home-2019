package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class Room {
    private Collection<Door> doors;
    private Collection<Light> lights;
    //private Collection<Devise> devices;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.doors = doors;
        this.lights = lights;
        this.name = name;
    }

    //public Room(String name) {
    //    this(new ArrayList<>(), name);
  //  }

    public Collection<Door> getDoors() {
        return doors;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    //public void addDevice(Devise device) {
      //  devices.add(device);
    //}

    public String getName() {
        return name;
    }
}

package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room {
    private Collection<Devise> lights;
    private Collection<Devise> doors;
    private String name;

    public Room(Collection<Devise> lights, Collection<Devise> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Devise> getLights() {
        return lights;
    }

    public Collection<Devise> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }
}

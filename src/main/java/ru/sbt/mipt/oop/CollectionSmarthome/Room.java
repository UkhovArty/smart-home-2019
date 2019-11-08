package ru.sbt.mipt.oop.CollectionSmarthome;

import ru.sbt.mipt.oop.EventProcessing.SensorEvent;

import java.util.Collection;

public class Room extends PartofTheHouse implements ComponentOfTheCollection {
    private Collection<Light> lights;
    private Collection<Door> doors;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(SensorEvent event, PartofTheHouse room) {
        for (Light light : getLights()) {
            light.execute(event, this);
        }
        for (Door door : getDoors()) {
            door.execute(event, this);
        }
    }
}

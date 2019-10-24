package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Door> doors;
    private Collection<Light> lights;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.doors = doors;
        this.lights = lights;
        this.name = name;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        for (Door door: getDoors()) {
            door.execute(action);
        }
        for (Light light: getLights()) {
            light.execute(action);
        }
    }
}
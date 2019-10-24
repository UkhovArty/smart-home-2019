package ru.sbt.mipt.oop.CollectionSmarthome;

import ru.sbt.mipt.oop.EventProcessing.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome extends PartofTheHouse implements ComponentOfTheCollection{
    private Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(SensorEvent event, PartofTheHouse smartHome) {
        for (Room room: getRooms()) {
            room.execute(event, room);
        }
    }
}

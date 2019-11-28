package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.Alarm;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    private final Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
        alarm = new Alarm("rightPassword");
    }

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.rooms = rooms;
        this.alarm = alarm;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        action.execute(alarm);
        for (Room room: getRooms()) {
            room.execute(action);
        }
    }
}
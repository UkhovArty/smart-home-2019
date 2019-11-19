package ru.sbt.mipt.oop.Tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.EventHandlers.DoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.EventHandlers.HallDoorEventHandler;

import java.util.Arrays;
import java.util.Collections;

public class HallDoorEventHandlerTest {
    private static EventHandler doorEventHandler;
    private static EventHandler hallDoorEventHandler;
    private static Light hallLight;
    private static Light bedroomLights;
    private static Door HallDoor;

    @BeforeAll
    static void setUp() {
        SmartHome smartHome = new SmartHome();
        HallDoor = new Door(true, "1", "hall");
        hallLight = new Light("2", true, "hall");
        bedroomLights = new Light("3", true, "bedroom");
        smartHome.addRoom(new Room(Arrays.asList(bedroomLights),  Collections.emptyList(), "bedroom"));
        smartHome.addRoom(new Room(Arrays.asList(hallLight), Arrays.asList(HallDoor), "hall"));
        doorEventHandler = new DoorEventHandler(smartHome);
        hallDoorEventHandler = new HallDoorEventHandler(smartHome);
    }

    @Test
    void closeHallDoorAndTurnOffLights() {
        SensorEvent HallDoorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        doorEventHandler.handleEvent(HallDoorEvent);
        hallDoorEventHandler.handleEvent(HallDoorEvent);
        Assert.assertFalse(hallLight.isOn());
        Assert.assertFalse(bedroomLights.isOn());
        Assert.assertFalse(HallDoor.isOpen());
    }
}

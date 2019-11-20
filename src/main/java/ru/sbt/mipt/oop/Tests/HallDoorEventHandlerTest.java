package ru.sbt.mipt.oop.Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.EventHandlers.DoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.EventHandlers.HallDoorEventHandler;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;

public class HallDoorEventHandlerTest {
    private static EventHandler doorEventHandler;
    private static EventHandler hallDoorEventHandler;
    private static Light hallLight;
    private static Light bedroomLight;
    private static Door hallDoor;

    @BeforeAll
    static void setUp() {
        SmartHome smartHome = new SmartHome();
        hallDoor = new Door(true, "1", "Hall");
        hallLight = new Light("2", true, "Hall");
        bedroomLight = new Light("3", true, "bedroom");
        smartHome.addRoom(new Room(Arrays.asList(bedroomLight),  Collections.emptyList(), "bedroom"));
        smartHome.addRoom(new Room(Arrays.asList(hallLight), Arrays.asList(hallDoor), "Hall"));
        doorEventHandler = new DoorEventHandler(smartHome);
        hallDoorEventHandler = new HallDoorEventHandler(smartHome);
    }

    @Test
    void closeHallDoorAndTurnOffLights() {
        SensorEvent HallDoorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        doorEventHandler.handleEvent(HallDoorEvent);
        hallDoorEventHandler.handleEvent(HallDoorEvent);
        assertFalse(hallLight.isSwitchState());
        assertFalse(bedroomLight.isSwitchState());
        assertFalse(hallDoor.isOpen());
    }
}
package ru.sbt.mipt.oop.Tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.EventHandlers.LightEventHandler;

import java.util.Arrays;

public class LightEventHandlerTests {
    private static EventHandler lightEventHandler;
    private static Door livingRoomDoor;
    private static Light livingRoomLight;


    @BeforeAll
    static void setUp() {
        SmartHome smartHome = new SmartHome();
        livingRoomDoor = new Door(true, "1", "livingroom");
        livingRoomLight = new Light("3", true, "livingroom");
        smartHome.addRoom(new Room(Arrays.asList(livingRoomLight), Arrays.asList(livingRoomDoor), "livingroom"));
        lightEventHandler = new LightEventHandler(smartHome);
    }

    @Test
    void notLightEventTest() {
        SensorEvent lightEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");
        lightEventHandler.handleEvent(lightEvent);
        Assert.assertTrue(livingRoomLight.isSwitchState());
        Assert.assertTrue(livingRoomDoor.isOpen());
    }

    @Test
    void notRightObjectIdTest() {
        SensorEvent lightEvent = new SensorEvent(SensorEventType.LIGHT_OFF, "2");
        lightEventHandler.handleEvent((lightEvent));
        Assert.assertTrue(livingRoomLight.isSwitchState());
    }

    @Test
    void changeLightStateWithoutChangingDoorState() {
        SensorEvent lightEvent = new SensorEvent(SensorEventType.LIGHT_OFF, "3");
        lightEventHandler.handleEvent(lightEvent);
        Assert.assertFalse(livingRoomLight.isSwitchState());
        Assert.assertTrue(livingRoomDoor.isOpen());
    }
}

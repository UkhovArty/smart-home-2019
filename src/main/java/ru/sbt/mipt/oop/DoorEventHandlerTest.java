package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class DoorEventHandlerTest {
    @Test
    void testDoorEventHandler() throws IOException {
        List<Light> expected= new ArrayList<>();
        Reader read = new ReadFromFile();
        Light Light1 = new Light("1", true);
        Light Light2 = new Light("2", true);
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");
        expected.add(0, Light1);
        expected.add(1, Light2);
        SensorEvent event = new SensorEvent(LIGHT_ON, "1");
        SmartHome smartHome = read.read();
        DoorEventHandler eventHandler = new DoorEventHandler();
        eventHandler.handleEvent(kitchen, event, smartHome);
        Assert.assertEquals(expected, kitchen.getLights());
    }
}
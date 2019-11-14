package ru.sbt.mipt.oop.Tests;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class HallDoorEventHandlerTests {
    private static SmartHome smartHome;
    private static Room room;



    @Test
    public void NonDoorEventTest() {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "1");

    }
}

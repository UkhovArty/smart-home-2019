package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.EventHandlers.*;
import ru.sbt.mipt.oop.library.SensorEventsManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }
}
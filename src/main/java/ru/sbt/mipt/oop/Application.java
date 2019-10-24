package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.DoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.EventHandlers.HallDoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.LightEventHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read;
        read = new ReadFromFile();
        SmartHome smartHome = read.read();
        List<EventHandler> handlers = Arrays.asList(new DoorEventHandler(smartHome),
                new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        EventProcessor eventProcessor = new EventProcessor(handlers);
        HomeProcessor homeProcessor = new HomeProcessor(eventProcessor);
        //начинаем цикл обработки событий
        homeProcessor.run();
    }
}
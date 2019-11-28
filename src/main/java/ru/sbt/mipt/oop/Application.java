package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read;
        read = new ReadFromFile();
        SmartHome smartHome = read.read();
        for (Room room: smartHome.getRooms()) {
            System.out.println(room.getName());
        }
        List<EventHandler> handlers = Arrays.asList(new DoorEventHandler(smartHome),
                new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome), new AlarmEventHandler(smartHome));
        EventProcessor eventProcessor = new EventProcessor(handlers);
        HomeProcessor homeProcessor = new HomeProcessor(eventProcessor);
        //начинаем цикл обработки событий
        homeProcessor.run();
    }
}
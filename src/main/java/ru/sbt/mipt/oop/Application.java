package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read;
        read = new ReadFromFile();
        SmartHome smartHome = read.read();
        for (Room room: smartHome.getRooms()) {
          System.out.println(room.getDevices());
        }
        //List<EventHandler> handlers = Arrays.asList(new DoorEventHandler(smartHome),
        //        new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        //EventProcessor eventProcessor = new EventProcessor(handlers);
        //HomeProcessor homeProcessor = new HomeProcessor(eventProcessor);
        //начинаем цикл обработки событий
        //homeProcessor.run();
    }
}

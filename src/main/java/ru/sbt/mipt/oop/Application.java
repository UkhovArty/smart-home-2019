package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = ReadFromFile.read();
        // начинаем цикл обработки событий
        SensorEvent event = SensorEvent.getNextSensorEvent();
        EventProcessor.eventProcessing(event, smartHome);
    }
}

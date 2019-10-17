package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read = new ReadFromFile();
        SmartHome smartHome = read.read();
        // начинаем цикл обработки событий
        SensorEvent event = NewEventGetter.getNextSensorEvent();
        EventProcessor.eventProcessing(event, smartHome);
    }
}

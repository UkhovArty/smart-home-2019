package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;
import ru.sbt.mipt.oop.EventProcessing.EventProcessor;
import ru.sbt.mipt.oop.EventProcessing.NewEventGetter;
import ru.sbt.mipt.oop.EventProcessing.SensorEvent;
import ru.sbt.mipt.oop.Input.ReadFromFile;
import ru.sbt.mipt.oop.Input.Reader;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read = new ReadFromFile();
        SmartHome smartHome = read.read();
        // начинаем цикл обработки событий
        SensorEvent event = NewEventGetter.getNextSensorEvent(smartHome);
        EventProcessor.eventProcessing(event, smartHome);
    }
}

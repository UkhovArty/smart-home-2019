package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.AlarmSystemContext;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;
import ru.sbt.mipt.oop.EventProcessing.EventProcessor;
import ru.sbt.mipt.oop.EventProcessing.NewEventGetter;
import ru.sbt.mipt.oop.EventProcessing.SensorEvent;
import ru.sbt.mipt.oop.Input.ReadFromFile;
import ru.sbt.mipt.oop.Input.Reader;

import java.io.IOException;

import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.ARMED;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Reader read = new ReadFromFile();
        SmartHome smartHome = read.read();
        // начинаем цикл обработки событий
        AlarmSystemContext alarmSystem = new AlarmSystemContext("12345");
        alarmSystem.setState(ARMED);
        SensorEvent event = NewEventGetter.getNextSensorEvent(smartHome);
        EventProcessor.eventProcessing(event, smartHome);
    }
}

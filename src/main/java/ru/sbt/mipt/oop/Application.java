package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.ConsoleSender;
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
        SignalSendingSystem sendingSystem = new ConsoleSender();
        List<EventHandler> handlers = Arrays.asList(new DoorEventHandler(smartHome),
                new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome), new AlarmEventHandler(smartHome));
        EventHandler homeHandler = new WorkingAlarmEventHandler(smartHome.getAlarm(), new EventProcessor(handlers),sendingSystem);
        HomeProcessor homeProcessor = new HomeProcessor(homeHandler);
        //начинаем цикл обработки событий
        homeProcessor.run();
    }
}
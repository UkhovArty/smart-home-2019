package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        Reader read;
        read = new ReadFromFile();
        SmartHome smartHome = read.read();
        SignalSendingSystem sendingSystem = new ConsoleSender();
        List<EventHandler> handlers = Arrays.asList(new DoorEventHandler(smartHome),
                new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome), new AlarmEventHandler(smartHome));

        EventProcessor eventProcessor = new EventProcessor(handlers);
        EventHandler homeHandler = new WorkingAlarmEventHandler(smartHome.alarm, eventProcessor, sendingSystem);

        HomeProcessor homeProcessor = new HomeProcessor(homeHandler);
        //начинаем цикл обработки событий
        homeProcessor.run();
    }
}
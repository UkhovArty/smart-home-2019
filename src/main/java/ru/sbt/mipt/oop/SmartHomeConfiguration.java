package ru.sbt.mipt.oop;

import com.google.gson.stream.JsonReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.EventAdapters.DoorEventAdapter;
import ru.sbt.mipt.oop.EventAdapters.EventAdapter;
import ru.sbt.mipt.oop.EventAdapters.LightEventAdapter;
import ru.sbt.mipt.oop.EventAdapters.SensorEventAdapter;
import ru.sbt.mipt.oop.EventHandlers.*;
import ru.sbt.mipt.oop.library.SensorEventsManager;

import java.util.Collection;
import java.util.List;

@Configuration
public class SmartHomeConfiguration {

    @Bean
    Reader reader() {
        return new ReadFromFile("output.js");
    }

    @Bean
    SmartHome smartHome() {
        return reader().read();
    }

    @Bean
    SensorEventsManager sensorEventsManager(List<EventHandler> handlers, Collection<EventAdapter> adapters) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        SignalSendingSystem sendingSystem = new ConsoleSender();
        sensorEventsManager.registerEventHandler(new WorkingAlarmEventHandler(smartHome().getAlarm(), new EventProcessor(handlers, eventAdapter(adapters)), sendingSystem));
        return sensorEventsManager;
    }


    @Bean
    EventAdapter eventAdapter(Collection<EventAdapter> adapters) {
        return new SensorEventAdapter(adapters);
    }

    @Bean
    EventAdapter doorEventAdapter() {
        return new DoorEventAdapter();
    }

    @Bean
    EventAdapter lightEventAdapter() {
        return new LightEventAdapter();
    }

    @Bean
    EventHandler alarmHandler() {
        return new AlarmEventHandler(smartHome());
    }

    @Bean
    EventHandler lightHandler() {
        return new LightEventHandler(smartHome());
    }

    @Bean
    EventHandler doorHandler() {
        return new DoorEventHandler(smartHome());
    }

    @Bean
    EventHandler hallDoorHandler() {
        return new HallDoorEventHandler(smartHome());
    }
}
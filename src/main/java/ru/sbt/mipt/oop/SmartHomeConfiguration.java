package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.EventAdapters.*;
import ru.sbt.mipt.oop.EventHandlers.*;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.remote.control.RemoteControlConfiguration;

import java.util.Collection;
import java.util.List;

@Configuration
@Import(RemoteControlConfiguration.class)
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
    SensorEventsManager sensorEventsManager(List<EventHandler> handlers, EventConverter eventConverter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new CCEventsAdapter(eventConverter, workingAlarmEventHandler(handlers)));
        return sensorEventsManager;
    }


    @Bean
    EventConverter eventConverter(Collection<EventConverter> adapters) {
        return new SensorEventAdapter(adapters);
    }

    @Bean
    EventConverter doorEventAdapter() {
        return new DoorEventAdapter();
    }

    @Bean
    EventConverter lightEventAdapter() {
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

    @Bean
    WorkingAlarmEventHandler workingAlarmEventHandler(List<EventHandler> handlers) {
        return new WorkingAlarmEventHandler(smartHome().getAlarm(), new EventProcessor(handlers), new ConsoleSender());
    }

}
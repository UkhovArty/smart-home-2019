package ru.sbt.mipt.oop.Tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.ActivatedState;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.Alarm;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.DeactivatedState;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.WorkingState;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.EventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.EventHandlers.EventHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvents.AlarmSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.DoorSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Arrays;

public class AlarmEventHandlerTests {
    private static Alarm alarm;
    private static EventHandler alarmEventHandler;

    @BeforeAll
    static void doBeforeAll() {
        alarm = new Alarm();
        SmartHome smartHome = new SmartHome();
        smartHome.setAlarm(alarm);
        alarmEventHandler = new AlarmEventHandler(smartHome);
    }

    @Test
    void fromActivatedToDeactivatedAlarmStateTest() {
        SensorEvent alarmActivationEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE,"1","rightPassword");
        alarmEventHandler.handleEvent(alarmActivationEvent);

        SensorEvent alarmDeactivationEvent = new AlarmSensorEvent(SensorEventType.ALARM_DEACTIVATE,"1","rightPassword");
        alarmEventHandler.handleEvent(alarmDeactivationEvent);
        Assert.assertTrue(alarm.getState() instanceof DeactivatedState);
    }

    @Test
    void fromActivatedStateToWorkingState() {
        SensorEvent alarmActivationEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE,"1","rightPassword");
        alarmEventHandler.handleEvent(alarmActivationEvent);
        alarm.WorkingState();
        Assert.assertTrue(alarm.getState() instanceof WorkingState);
    }

    @Test
    void fromDeactivatedStateToWorkingState() {
        alarm.WorkingState();
        Assert.assertTrue(alarm.getState() instanceof WorkingState);
    }

    @Test
    void fromDeactivatedtoActivatedAlarmStateTest() {
        SensorEvent alarmDeactivationEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE,"1","rightPassword");
        alarmEventHandler.handleEvent(alarmDeactivationEvent);
        Assert.assertTrue(alarm.getState() instanceof ActivatedState);
    }

    @Test
    void fromActivatedToWorkingAlarmStateTest() {
        SensorEvent alarmActivationEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE,"1","rightPassword");
        alarmEventHandler.handleEvent(alarmActivationEvent);
        alarm.WorkingState();
        Assert.assertTrue(alarm.getState() instanceof WorkingState);
    }

}

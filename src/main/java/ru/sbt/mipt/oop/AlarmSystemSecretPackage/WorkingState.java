package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import ru.sbt.mipt.oop.CollectionSmarthome.Light;
import ru.sbt.mipt.oop.CollectionSmarthome.Room;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;
import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.Sender;
import ru.sbt.mipt.oop.SensorCommand;

import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.ALARM_IN_PROCESS;
import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.DISARMED;

public class WorkingState extends AlarmState {

    public WorkingState(AlarmSystemContext context, SmartHome smartHome) {
        super(context, smartHome);
        this.type = ALARM_IN_PROCESS;

    }
}


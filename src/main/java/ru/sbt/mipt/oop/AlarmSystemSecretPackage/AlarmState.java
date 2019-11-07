package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

public abstract class AlarmState {
    private AlarmSystemContext context;
    public StatesOfTheAlarmSystem type;
    private final SmartHome smartHome;
    public AlarmState (AlarmSystemContext context, SmartHome smartHome) {
        this.context = context;
        context.state = this;
        this.smartHome = smartHome;
    }

}

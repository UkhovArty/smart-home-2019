package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.ARMED;

public class ArmedState extends AlarmState {
    public ArmedState(AlarmSystemContext context) {
        super(context);
        this.type = ARMED;
    }

}

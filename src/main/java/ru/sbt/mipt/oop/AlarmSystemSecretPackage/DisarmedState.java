package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.DISARMED;

public class DisarmedState extends AlarmState {
    public DisarmedState(AlarmSystemContext context) {
        super(context);
        this.type = DISARMED;
    }
}

package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.StatesOfTheAlarmSystem.DISARMED;

public class DisarmedState extends AlarmState {
    public DisarmedState(AlarmSystemContext context) {
        super(context);
        this.type = DISARMED;
    }
}

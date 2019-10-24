package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.StatesOfTheAlarmSystem.ARMED;

public class ArmedState extends AlarmState {
    public ArmedState(AlarmSystemContext context) {
        super(context);
        this.type = ARMED;
    }

}

package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.StatesOfTheAlarmSystem.ALARM_IN_PROCESS;

public class WorkingState extends AlarmState {

    public WorkingState(AlarmSystemContext context) {
        super(context);
        this.type = ALARM_IN_PROCESS;
    }
}

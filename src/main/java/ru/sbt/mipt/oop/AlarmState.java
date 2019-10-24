package ru.sbt.mipt.oop;

public abstract class AlarmState {
    private AlarmSystemContext context;
    StatesOfTheAlarmSystem type;
    public AlarmState (AlarmSystemContext context) {
        this.context = context;
        context.state = this;
    }

}

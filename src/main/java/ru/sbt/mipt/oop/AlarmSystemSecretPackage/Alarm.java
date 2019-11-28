package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Alarm implements AlarmSystem, Actionable {
    private String code;
    private AlarmState state;

    public Alarm(String code) {
        this.code = code;
        this.state = new DeactivatedState(this, code);
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    @Override
    public void activate(String code) {
        state.activate(code);
    }

    @Override
    public void deactivate(String code) {
        state.deactivate(code);
    }

    @Override
    public void makeAlarmWork() {
        state.makeAlarmWork();
    }
}

package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Alarm implements AlarmSystem, Actionable {
    private String code = "";
    private AlarmSystem state = new DeactivatedState(this);

    public void setState(AlarmSystem state) {
        this.state = state;
    }

    public AlarmSystem getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

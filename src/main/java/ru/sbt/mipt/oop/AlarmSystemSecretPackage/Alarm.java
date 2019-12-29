package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Alarm implements Actionable {
    private AlarmSystem state = new DeactivatedState(this);
    private String code = "";

    public boolean checkCode(String code){
        return code.equals(this.code);
    }

    public void setState(AlarmSystem state) {
        this.state = state;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AlarmSystem getState() {
        return state;
    }

    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void WorkingState() {
        state.makeAlarmWork();
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
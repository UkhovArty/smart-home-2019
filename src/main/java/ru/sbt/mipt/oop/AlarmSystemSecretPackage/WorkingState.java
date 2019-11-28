package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class WorkingState extends AlarmState {

    private String code;

    public WorkingState(Alarm alarm, String code) {
        this.code = code;
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public void makeAlarmWork() {
    }
}

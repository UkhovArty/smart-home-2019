package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class ActivatedState implements AlarmSystem {

    private Alarm alarm;

    public ActivatedState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (alarm.getCode().equals(code)) {
            alarm.setState(new DeactivatedState(alarm));
        } else {
            alarm.setState(new WorkingState(alarm));
        }
    }

    @Override
    public void makeAlarmWork() {
        alarm.setState(new WorkingState(alarm));
    }
}

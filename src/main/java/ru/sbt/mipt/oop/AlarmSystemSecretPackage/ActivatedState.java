package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class ActivatedState extends AlarmState {

    private String code;

    public ActivatedState(Alarm alarm, String code) {
        this.alarm = alarm;
        this.code = code;
    }

    @Override
    void activate(String code) {
    }

    @Override
    void deactivate(String code) {
        if (this.code.equals(code)) {
            alarm.setState(new DeactivatedState(alarm, code));
        } else {
            alarm.setState(new WorkingState(alarm, code));
        }
    }

    @Override
    void makeAlarmWork() {
        alarm.setState(new WorkingState(alarm, code));
    }
}

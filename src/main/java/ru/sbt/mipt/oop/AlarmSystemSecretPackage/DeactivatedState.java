package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class DeactivatedState extends AlarmState {

    private String code;

    public DeactivatedState(Alarm alarm, String code) {
        this.code = code;
        this.alarm = alarm;
    }

    @Override
    void activate(String code) {
        if (code.equals(this.code)) {
            alarm.setState(new ActivatedState(alarm, code));
        } else {
            System.out.println("Wrong Password");
        }
    }

    @Override
    void deactivate(String code) {
    }

    @Override
    void makeAlarmWork() {
        alarm.setState(new WorkingState(alarm, code));
    }
}

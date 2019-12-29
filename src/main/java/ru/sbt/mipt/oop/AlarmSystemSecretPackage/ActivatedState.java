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
        if (alarm.checkCode(code)) {
            alarm.setState(new DeactivatedState(alarm));
            System.out.println("Alarm system was deactivated");
        } else {
            alarm.setState(new WorkingState(alarm));
            System.out.println("Ur code is incorrect, I am calling the police NOW!");
        }
    }

    @Override
    public void makeAlarmWork() {
        alarm.setState(new WorkingState(alarm));
        System.out.println("I am calling the police NOW!");
    }
}

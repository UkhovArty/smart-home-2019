package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class DeactivatedState implements AlarmSystem {

    private Alarm alarm;

    public DeactivatedState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.setCode(code);
        alarm.setState(new ActivatedState(alarm));
        System.out.println("Alarm activated");
    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public void makeAlarmWork() {
        alarm.setState(new WorkingState(alarm));
        System.out.println("Alarm is working!");
    }
}

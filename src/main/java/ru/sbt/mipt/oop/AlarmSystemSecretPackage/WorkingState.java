package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public class WorkingState implements AlarmSystem {

    private Alarm alarm;

    public WorkingState (Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        if (alarm.checkCode(code)) {
            alarm.setState(new ActivatedState(alarm));
            System.out.println("Alert stopped, state changed to 'Activated'");
        }
    }

    @Override
    public void deactivate(String code) {
        if (alarm.checkCode(code)) {
            alarm.setState(new DeactivatedState(alarm));
            System.out.println("Alert stopped, state changed to 'deactivated'");
        } else {
            System.out.println("Ne stoilo syuda prihodit'! 'Skyrim battle music playing'");
        }
    }

    @Override
    public void makeAlarmWork() {
    }
}

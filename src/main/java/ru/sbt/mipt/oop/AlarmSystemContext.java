package ru.sbt.mipt.oop;

import java.util.Scanner;

import static ru.sbt.mipt.oop.StatesOfTheAlarmSystem.ALARM_IN_PROCESS;

public class AlarmSystemContext {
    private String password;
    public AlarmState state;
    public AlarmSystemContext(String password) {
        this.password = password;
    }
    public void setState(AlarmState state) {
        System.out.println("Enter a password, please");
        Scanner scanner = new Scanner(System.in);
        if (password == scanner.nextLine()) {
            this.state = state;
        } else {
            this.state = new WorkingState(this);
        }
    }
}

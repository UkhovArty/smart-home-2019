package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import java.util.Scanner;

public class AlarmSystemContext {
    private String password;
    public AlarmState state;
    public AlarmSystemContext(String password) {
        this.password = password;
    }
    public void setState(StatesOfTheAlarmSystem type) {
        System.out.println("Enter a password, please");
        Scanner scanner = new Scanner(System.in);
        if (password == scanner.nextLine()) {
            switch (type) {
                case ARMED:
                    this.state = new ArmedState(this);
                case DISARMED:
                    this.state = new DisarmedState(this);
                case ALARM_IN_PROCESS:
                    this.state = new WorkingState(this);
            }
        } else {
            this.state = new WorkingState(this);
        }
    }
}

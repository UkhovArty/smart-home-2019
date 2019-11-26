package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Alarm {
    private String code;
    private AlarmState state;

    public Alarm(String code, AlarmState state) {
        this.code = code;
        this.state = state;
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }
}

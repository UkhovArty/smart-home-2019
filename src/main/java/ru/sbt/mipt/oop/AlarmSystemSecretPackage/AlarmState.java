package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public abstract class AlarmState {

    transient protected Alarm alarm;

    abstract void activate(String code);

    abstract void deactivate(String code);

    abstract void makeAlarmWork();

}

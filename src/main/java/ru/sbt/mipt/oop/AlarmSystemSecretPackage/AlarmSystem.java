package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public interface AlarmSystem {

    public void activate(String code);

    public void deactivate(String code);

    public void makeAlarmWork();

}

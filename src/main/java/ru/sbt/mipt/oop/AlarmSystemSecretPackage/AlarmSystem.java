package ru.sbt.mipt.oop.AlarmSystemSecretPackage;

public interface AlarmSystem {

    void activate(String code);

    void deactivate(String code);

    void makeAlarmWork();

}

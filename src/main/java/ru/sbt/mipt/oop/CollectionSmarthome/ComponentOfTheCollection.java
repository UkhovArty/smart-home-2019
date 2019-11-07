package ru.sbt.mipt.oop.CollectionSmarthome;

import ru.sbt.mipt.oop.EventProcessing.SensorEvent;

public interface ComponentOfTheCollection {
    public void execute(SensorEvent event, PartofTheHouse part);
}

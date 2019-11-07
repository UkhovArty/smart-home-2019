package ru.sbt.mipt.oop.Input;

import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;

import java.io.IOException;

public interface Reader {
    SmartHome read()throws IOException;
}

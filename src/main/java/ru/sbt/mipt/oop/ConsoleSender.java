package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SignalSendingSystem;

public class ConsoleSender implements SignalSendingSystem {
    @Override
    public void sendSignal(String signal) {
        System.out.println(signal);
    }
}

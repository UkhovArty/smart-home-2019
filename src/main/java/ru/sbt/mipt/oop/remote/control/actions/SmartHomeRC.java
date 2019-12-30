package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.rc.RemoteControl;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRC implements RemoteControl {

    private final Map<String, RemoteControlAction> commands = new HashMap<>();
    private String remoteControlId;

    public SmartHomeRC(String remoteControlId) {
        this.remoteControlId = remoteControlId;
    }

    public void addCommand(String buttonCode, RemoteControlAction command) {
        commands.put(buttonCode, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (rcId.equals(this.remoteControlId) && commands.containsKey(buttonCode)) {
            commands.get(buttonCode).execute();
        }
    }
}


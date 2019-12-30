package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class AllLightsSwitchAction implements RemoteControlAction {

    private SmartHome smartHome;
    private boolean SetUp;

    public AllLightsSwitchAction(SmartHome smartHome, boolean SetUp) {
        this.smartHome = smartHome;
        this.SetUp = SetUp;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Light) {
                ((Light) o).setSwitchState(SetUp);
                String isOn = SetUp ? "on" : "off";
                System.out.println("All lights were turned " + isOn + "using rc");
            }
        });
    }
}


package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.Alarm;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmToActiveStateSettingAction implements RemoteControlAction {

    private SmartHome smartHome;

    public AlarmToActiveStateSettingAction(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Alarm) {
                ((Alarm) o).activate("rightPassword");
                System.out.println("Alarm state was set active from rc");
            }
        });
    }
}


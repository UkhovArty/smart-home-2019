package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.Alarm;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmActivationAction implements RemoteControlAction {

    private SmartHome smartHome;

    public AlarmActivationAction(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Alarm) {
                ((Alarm) o).WorkingState();
                System.out.println("Alarm state set to working state from rc");
            }
        });
    }
}

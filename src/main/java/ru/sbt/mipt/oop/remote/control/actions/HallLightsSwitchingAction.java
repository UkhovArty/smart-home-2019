package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class HallLightsSwitchingAction implements RemoteControlAction {

    private SmartHome smartHome;

    public HallLightsSwitchingAction(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Room && ((Room) o).getName().equals("hall")) {
                ((Room) o).execute(o1 -> {
                    if (o1 instanceof Light) {
                        ((Light) o1).setSwitchState(true);
                        System.out.println("Hall lights turned on using rc");
                    }
                });
            }
        });
    }
}


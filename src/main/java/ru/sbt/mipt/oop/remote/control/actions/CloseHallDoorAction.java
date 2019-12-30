package ru.sbt.mipt.oop.remote.control.actions;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CloseHallDoorAction implements RemoteControlAction {

    private SmartHome smartHome;

    public CloseHallDoorAction(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Room && ((Room) o).getName().equals("hall")) {
                ((Room) o).execute(o1 -> {
                    if (o1 instanceof Door) {
                        ((Door) o1).setOpen(false);
                        System.out.println("Hall door was closed using rc");
                    }
                });
            }
        });
    }
}

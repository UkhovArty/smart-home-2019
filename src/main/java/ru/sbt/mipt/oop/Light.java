package ru.sbt.mipt.oop;

public class Light implements Actionable {
    private boolean switchState;
    private final String id;
    private final String type = "light";
    private final String roomName;

    public Light(String id, boolean isOn, String roomName) {
        this.switchState = isOn;
        this.id = id;
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isSwitchState() {
        return switchState;
    }

    public String getType() {
        return "light";
    }

    public String getId() {
        return id;
    }

    public void setSwitchState(boolean someState) {
        this.switchState = someState;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
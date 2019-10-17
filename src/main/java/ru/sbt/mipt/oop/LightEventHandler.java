package ru.sbt.mipt.oop;

public class LightEventHandler implements EventHandler {
    @Override
    public void handleEvent(Room room, SensorEvent event, SmartHome smarthome) {
        for (Devise devise : room.getLights()) {
            if (devise.getId().equals(event.getObjectId())) {
                switch (event.getType()) {
                    case LIGHT_ON:
                        devise.setOn(true);
                        System.out.println("Light " + devise.getId() + " in room " + room.getName() + " was turned on.");
                        break;
                    case LIGHT_OFF:
                        devise.setOn(false);
                        System.out.println("Light " + devise.getId() + " in room " + room.getName() + " was turned off.");
                        break;
                }
            }
        }
    }
}

package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class EventManager {
    static Collection<Devise> collection;
    static void manageEvent(SmartHome smartHome, SensorEvent event, int identificator) {
        for (Room room : smartHome.getRooms()) {
            switch (identificator) {
                case 1:
                    collection = room.getDoors();
                    break;
                case 0:
                    collection = room.getLights();
            }
            for (Devise devise : collection) {
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
                        case DOOR_OPEN:
                            devise.setOn(true);
                            System.out.println("Door " + devise.getId() + " in room " + room.getName() + " was opened.");
                            break;
                        case DOOR_CLOSED:
                            devise.setOn(false);
                            System.out.println("Door " + devise.getId() + " in room " + room.getName() + " was closed.");
                            // если мы получили событие о закрытии двери в холле - это значит, что была закрыта входная дверь.
                            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                            if (room.getName().equals("hall")) {
                                for (Room homeRoom : smartHome.getRooms()) {
                                    for (Devise light : homeRoom.getLights()) {
                                        light.setOn(false);
                                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                        Sender.sendCommand(command);
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
    }
}

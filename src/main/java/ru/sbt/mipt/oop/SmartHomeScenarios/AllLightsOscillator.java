package ru.sbt.mipt.oop.SmartHomeScenarios;

import ru.sbt.mipt.oop.AlarmSystemSecretPackage.AlarmSystemContext;
import ru.sbt.mipt.oop.CollectionSmarthome.Light;
import ru.sbt.mipt.oop.CollectionSmarthome.Room;
import ru.sbt.mipt.oop.CollectionSmarthome.SmartHome;
import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.Sender;
import ru.sbt.mipt.oop.SensorCommand;

import static ru.sbt.mipt.oop.AlarmSystemSecretPackage.StatesOfTheAlarmSystem.DISARMED;

public class AllLightsOscillator {
    public static void OscillateAllLights(AlarmSystemContext context, SmartHome smartHome) {
        while (context.state.type != DISARMED) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    Sender.sendCommand(command);
                }
            }
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(true);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_ON, light.getId());
                    Sender.sendCommand(command);
                }
            }
        }
    }
}

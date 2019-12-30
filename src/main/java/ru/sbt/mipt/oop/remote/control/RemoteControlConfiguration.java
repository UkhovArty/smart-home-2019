package ru.sbt.mipt.oop.remote.control;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.remote.control.actions.*;


@Configuration
public class RemoteControlConfiguration {

    @Bean
    public RemoteControl remoteControl(AlarmToActiveStateSettingAction activate,
                                             @Qualifier("LightsOn") AllLightsSwitchAction LightsOn,
                                             @Qualifier("LightsOff") AllLightsSwitchAction LightsOff,
                                             CloseHallDoorAction closeHallDoor,
                                             AlarmActivationAction alarm,
                                             HallLightsSwitchingAction hallLightsOn,
                                             RemoteControlRegistry remoteControlRegistry) {
        SmartHomeRC rc = new SmartHomeRC("1");
        rc.addCommand("A", activate);
        rc.addCommand("B", LightsOn);
        rc.addCommand("C", LightsOff);
        rc.addCommand("D", closeHallDoor);
        rc.addCommand("1", alarm);
        rc.addCommand("2", hallLightsOn);
        remoteControlRegistry.registerRemoteControl(rc, "1");
        return rc;
    }

    @Bean
    public RemoteControlRegistry remoteControlRegistry(){
        return new RemoteControlRegistry();
    }

    @Bean
    public CloseHallDoorAction closeHallDoor(SmartHome smartHome) {
        return new CloseHallDoorAction(smartHome);
    }

    @Bean
    public HallLightsSwitchingAction hallLightsOn(SmartHome smartHome) {
        return new HallLightsSwitchingAction(smartHome);
    }

    @Bean
    public AllLightsSwitchAction LightsOn(SmartHome smartHome) {
        return new AllLightsSwitchAction(smartHome, true);
    }

    @Bean
    public AllLightsSwitchAction LightsOff(SmartHome smartHome) {
        return new AllLightsSwitchAction(smartHome, false);
    }

    @Bean
    public AlarmToActiveStateSettingAction activate(SmartHome smartHome) {
        return new AlarmToActiveStateSettingAction(smartHome);
    }

    @Bean
    public AlarmActivationAction alarm(SmartHome smartHome) {
        return new AlarmActivationAction(smartHome);
    }
}
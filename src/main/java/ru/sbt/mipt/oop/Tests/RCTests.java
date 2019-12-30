package ru.sbt.mipt.oop.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.ActivatedState;
import ru.sbt.mipt.oop.AlarmSystemSecretPackage.WorkingState;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeConfiguration;
import static org.junit.jupiter.api.Assertions.*;

class RCTests {

    private SmartHome smartHome;
    private RemoteControl rc;

    @BeforeEach
    void start() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        smartHome = context.getBean(SmartHome.class);
        rc = (RemoteControl) context.getBean("remoteControl");
    }

    @Test
    public void checkWorkingStateActivation() {
        rc.onButtonPressed("1", "1");
        assertTrue(smartHome.getAlarm().getState() instanceof WorkingState);
    }

    @Test
    public void checkAlarmActivationAction() {
        rc.onButtonPressed("A", "1");
        assertTrue(smartHome.getAlarm().getState() instanceof ActivatedState);
    }

    @Test
    public void checkAllLightsSwitchingAction() {
        rc.onButtonPressed("B", "1");
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                assertTrue(light.isSwitchState());
            }
        }
    }


}


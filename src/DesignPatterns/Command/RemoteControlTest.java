package DesignPatterns.Command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        SimpleRemoteControl remote2 = new SimpleRemoteControl();
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(garageDoor);

        remote2.setCommand(doorOpen);
        remote2.buttonWasPressed();
    }
}

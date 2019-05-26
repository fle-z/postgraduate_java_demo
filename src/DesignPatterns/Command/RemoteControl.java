package DesignPatterns.Command;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    private static final int NUM_SLOTS = 7;

    public RemoteControl() {
        onCommands = new Command[NUM_SLOTS];
        offCommands = new Command[NUM_SLOTS];

        // 创建一个空对象，避免每次检查是否某个插槽加载了命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control -----\n");

        for (int i =0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
            + "    " + offCommands[i].getClass().getName() + "\n");
        }

        return stringBuffer.toString();
    }
}

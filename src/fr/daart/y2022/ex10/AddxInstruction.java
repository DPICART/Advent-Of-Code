package fr.daart.y2022.ex10;

public class AddxInstruction extends Instruction {

    public static final String NAME = "addx";

    public AddxInstruction(int value) {
        this.value = value;
    }

    public static AddxInstruction from(String rawString) {
        var value = Integer.parseInt(rawString.split(" ")[1]);
        return new AddxInstruction(value);
    }

    private int value;

    @Override
    public void execute() {
        executionCount++;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getExecutionTimeNeeded() {
        return 2;
    }
}

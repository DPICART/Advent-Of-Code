package fr.daart.y2022.ex10;

public class NoopInstruction extends Instruction {

    public static final String NAME = "noop";

    @Override
    public void execute() {
        // Do nothing
        executionCount++;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int getExecutionTimeNeeded() {
        return 1;
    }
}

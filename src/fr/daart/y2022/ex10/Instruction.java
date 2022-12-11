package fr.daart.y2022.ex10;

public abstract class Instruction {
    protected int executionCount = 0;

    public static Instruction from(String rawString) {

        if(rawString.startsWith(NoopInstruction.NAME)) {
            return new NoopInstruction();
        } else if(rawString.startsWith(AddxInstruction.NAME)) {
            return AddxInstruction.from(rawString);
        } else {
            throw new IllegalArgumentException("Unknown instruction");
        }

    }
    public abstract void execute();
    public abstract int getValue();
    public abstract int getExecutionTimeNeeded();
    public boolean isComplete() {
        return getExecutionTimeNeeded() == executionCount;
    }

}

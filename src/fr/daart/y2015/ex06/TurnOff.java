package fr.daart.y2015.ex06;

import java.util.function.Function;

public class TurnOff extends Instruction {

    public static final String NAME = "turn off ";

    public TurnOff(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public Function<Boolean, Boolean> getFunction() {
        return (state) -> false;
    }
}

package fr.daart.y2015.ex06;

import java.util.function.Function;

public class P2TurnOff extends P2Instruction {

    public static final String NAME = "turn off ";

    public P2TurnOff(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public Function<Long, Long> getFunction() {
        return (state) -> Math.max(state - 1, 0);
    }
}

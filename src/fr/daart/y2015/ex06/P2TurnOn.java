package fr.daart.y2015.ex06;

import java.util.function.Function;

public class P2TurnOn extends P2Instruction {

    public static final String NAME = "turn on ";

    public P2TurnOn(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public Function<Long, Long> getFunction() {
        return (state) -> state + 1;
    }
}

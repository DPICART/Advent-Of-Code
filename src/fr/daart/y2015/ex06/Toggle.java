package fr.daart.y2015.ex06;

import java.util.function.Function;

public class Toggle extends Instruction {

    public static final String NAME = "toggle ";

    public Toggle(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public Function<Boolean, Boolean> getFunction() {
        return (state) -> !state;
    }
}

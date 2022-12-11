package fr.daart.y2015.ex06;

import java.util.ArrayList;
import java.util.List;

public class P2LightGrid {

    private long[][] lights;
    private final int width;
    private final int height;

    private List<P2Instruction> instructions = new ArrayList<>();

    public P2LightGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.lights = new long[height][width];
    }

    public void addInstruction(P2Instruction instruction) {
        this.instructions.add(instruction);
    }

    public void execute() {
        for(var instruction : instructions) {
            instruction.applyOn(this.lights);
        }
    }

    public long getTotalBrightness() {

        long counter = 0;

        for(var a : lights) {
            for(var b : a) {
                counter += b;
            }
        }

        return counter;
    }
}

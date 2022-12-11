package fr.daart.y2015.ex06;

import java.util.ArrayList;
import java.util.List;

public class LightGrid {

    private boolean[][] lights;
    private final int width;
    private final int height;

    private List<Instruction> instructions = new ArrayList<>();

    public LightGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.lights = new boolean[height][width];
    }

    public void addInstruction(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public void execute() {
        for(var instruction : instructions) {
            instruction.applyOn(this.lights);
        }
    }

    public int countLit() {

        int counter = 0;

        for(var a : lights) {
            for(var b : a) {
                if(b) counter++;
            }
        }

        return counter;
    }
}

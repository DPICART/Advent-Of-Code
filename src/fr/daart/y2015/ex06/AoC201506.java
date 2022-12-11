package fr.daart.y2015.ex06;

import fr.daart.y2015.AoC2015;

public class AoC201506 extends AoC2015 {
    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");

        var grid = new LightGrid(1000, 1000);

        for(var line : input) {
            var instruction = Instruction.from(line);
            grid.addInstruction(instruction);
        }

        grid.execute();

        var result = grid.countLit();
        System.out.println("Part 1: "+result);
    }

@Override
    public void part2() {

    var input = readInput("input.txt");

    var grid = new P2LightGrid(1000, 1000);

    for(var line : input) {
        var instruction = P2Instruction.from(line);
        grid.addInstruction(instruction);
    }

    grid.execute();

    var result = grid.getTotalBrightness();
    System.out.println("Part 2: "+result);
    }
}

package fr.daart.y2022.ex10;

import fr.daart.y2022.AoC2022;


public class AoC202210 extends AoC2022 {
    @Override
    public int getDay() {
        return 10;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");

        var cpu = new SimpleCPU();

        for(var line : input) {
            var instruction = Instruction.from(line);
            cpu.addInstruction(instruction);
        }


        do {

            cpu.tick();

        } while(cpu.isWorking());

        var result = cpu.getPart1Stored().stream().reduce(Integer::sum).get();
        System.out.println("Part 1: " + result);
    }


    @Override
    public void part2() {

            var input = readInput("input.txt");

            var cpu = new SimpleCPU();

            for(var line : input) {
                var instruction = Instruction.from(line);
                cpu.addInstruction(instruction);
            }


            do {

                cpu.tick();

            } while(cpu.isWorking());

            // SPRITE
            // X-1 | X | X+1
            // ########################################


            var result = cpu.getCRTImage(); // to be read in console

            System.out.println("Part 2: " + result);

    }




}

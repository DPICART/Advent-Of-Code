package fr.daart.ex09;

import fr.daart.AoC2022;

public class AoC09 extends AoC2022 {

    @Override
    public Class getClazz() {
        return this.getClass();
    }

    @Override
    public int getDay() {
        return 9;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");

        var cord = new CordPart(0, 0, 0);
        var cordLength = 2;
        var currentCord = cord;

        for (int i = 0; i < cordLength - 1; i++) {
            currentCord = currentCord.addNext();
        }


        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i).split(" ");

            int dX = 0;
            int dY = 0;
            switch (line[0]) {
                case "U":
                    dY += 1;
                    break;
                case "D":
                    dY -= 1;
                    break;
                case "L":
                    dX -= 1;
                    break;
                case "R":
                    dX += 1;
                    break;
            }

            cord.move(Integer.parseInt(line[1]), dX, dY);
        }

        var result = cord.getTail().getVisited().size();
        System.out.println("Part 1: " + result);
    }

    @Override
    public void part2() {

        var input = readInput("input.txt");

        var cord = new CordPart(0, 0, 0);
        var cordLength = 10;
        var currentCord = cord;

        for (int i = 0; i < cordLength - 1; i++) {
            currentCord = currentCord.addNext();
        }


        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i).split(" ");

            int dX = 0;
            int dY = 0;
            switch (line[0]) {
                case "U":
                    dY += 1;
                    break;
                case "D":
                    dY -= 1;
                    break;
                case "L":
                    dX -= 1;
                    break;
                case "R":
                    dX += 1;
                    break;
            }

            cord.move(Integer.parseInt(line[1]), dX, dY);
        }

        var result = cord.getTail().getVisited().size();
        System.out.println("Part 2: " + result);
    }
}

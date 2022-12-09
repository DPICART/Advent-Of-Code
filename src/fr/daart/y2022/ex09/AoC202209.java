package fr.daart.y2022.ex09;

import fr.daart.y2022.AoC2022;

public class AoC202209 extends AoC2022 {


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


        for (String s : input) {
            var line = s.split(" ");

            int dX = 0;
            int dY = 0;
            switch (line[0]) {
                case "U" -> dY += 1;
                case "D" -> dY -= 1;
                case "L" -> dX -= 1;
                case "R" -> dX += 1;
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

        for (String s : input) {
            var line = s.split(" ");
            int dX = 0;
            int dY = 0;
            switch (line[0]) {
                case "U" -> dY += 1;
                case "D" -> dY -= 1;
                case "L" -> dX -= 1;
                case "R" -> dX += 1;
            }
            cord.move(Integer.parseInt(line[1]), dX, dY);
        }

        var result = cord.getTail().getVisited().size();
        System.out.println("Part 2: " + result);
    }
}

package fr.daart.y2022.ex02;

import fr.daart.y2022.AoC2022;

public class AoC202202 extends AoC2022 {


    @Override
    public int getDay() {
        return 2;
    }

    /*
        A X rock
        B Y paper
        C Z scissor

        rock 1
        paper 2
        scissors 3

        lost 0
        draw 3
        win 6

     */

    @Override
    public void part1() {
        var input = readInput("input.txt");

        int totalScore = 0;

        for (String line : input) {
            var splitted = line.split(" ");
            var ennemy = splitted[0];
            var self = splitted[1];
            var score = getSelfScore(ennemy, self);
            //System.out.println("Tour n°" + i + " Score:\t" + score);
            totalScore += score;
        }

        System.out.println("Part 1: " + totalScore);
    }

    @Override
    public void part2() {

        var input = readInput("input.txt");

        int totalScore = 0;
        for (String line : input) {
            var splitted = line.split(" ");
            var ennemy = splitted[0];
            var target = splitted[1];
            var score = getFakedScore(ennemy, target);
            //System.out.println("Tour n°" + i + " Score:\t" + score);
            totalScore += score;
        }
        System.out.println("Part 2: " + totalScore);

    }


    /*
    X LOOSE
    Y DRAW
    Z WIN
    A ROCK 1
    B PAPER 2
    C SCISSOR 3
     */
    private int getFakedScore(String ennemy, String target) {
        int roundPoint = 0;
        int fakePoint = 0;
        switch (target) {
            case "X" -> {  // je dois perdre
                switch (ennemy) {
                    case "A" -> fakePoint = 3;
                    case "B" -> fakePoint = 1;
                    case "C" -> fakePoint = 2;
                }
            }
            case "Y" -> {
                roundPoint = 3;
                fakePoint = switch (ennemy) {
                    case "A" -> 1;
                    case "B" -> 2;
                    case "C" -> 3;
                    default -> fakePoint;
                };
            }
            case "Z" -> {
                roundPoint = 6;
                fakePoint = switch (ennemy) {
                    case "A" -> 2;
                    case "B" -> 3;
                    case "C" -> 1;
                    default -> fakePoint;
                };
            }
        }
        return roundPoint + fakePoint;
    }

    private int getSelfScore(String ennemy, String self) {

        int selfPoint = 0;
        int roundPoint = 0;

        switch (self) {
            case "X" -> {
                selfPoint = 1;
                switch (ennemy) {
                    case "A" -> roundPoint = 3;
                    case "C" -> roundPoint = 6;
                }
            }
            case "Y" -> {
                selfPoint = 2;
                switch (ennemy) {
                    case "A" -> roundPoint = 6;
                    case "B" -> roundPoint = 3;
                }
            }
            case "Z" -> {
                selfPoint = 3;
                switch (ennemy) {
                    case "B" -> roundPoint = 6;
                    case "C" -> roundPoint = 3;
                }
            }
        }

        return roundPoint + selfPoint;
    }
}

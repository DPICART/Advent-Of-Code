package fr.daart.ex02;

import fr.daart.AoC2022;

public class AoC02 extends AoC2022 {

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

        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
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
        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
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
        if (target.equals("X")) { // je dois perdre
            roundPoint = 0;
            if (ennemy.equals("A")) {
                fakePoint = 3;
            } else if (ennemy.equals("B")) {
                fakePoint = 1;
            } else if (ennemy.equals("C")) {
                fakePoint = 2;
            }
        } else if (target.equals("Y")) {
            roundPoint = 3;
            if (ennemy.equals("A")) {
                fakePoint = 1;
            } else if (ennemy.equals("B")) {
                fakePoint = 2;
            } else if (ennemy.equals("C")) {
                fakePoint = 3;
            }
        } else if (target.equals("Z")) {
            roundPoint = 6;

            if (ennemy.equals("A")) {
                fakePoint = 2;
            } else if (ennemy.equals("B")) {
                fakePoint = 3;
            } else if (ennemy.equals("C")) {
                fakePoint = 1;
            }
        }
        return roundPoint + fakePoint;
    }

    private int getSelfScore(String ennemy, String self) {


        int selfPoint = 0;
        int roundPoint = 0;

        switch (self) {
            case "X":
                selfPoint = 1;
                if (ennemy.equals("A")) {
                    // draw
                    roundPoint = 3;
                } else if (ennemy.equals("B")) {
                    // lost
                } else if (ennemy.equals("C")) {
                    // win
                    roundPoint = 6;
                }
                break;
            case "Y":
                selfPoint = 2;
                if (ennemy.equals("A")) {
                    // win
                    roundPoint = 6;
                } else if (ennemy.equals("B")) {
                    // draw
                    roundPoint = 3;
                } else if (ennemy.equals("C")) {
                    // lost
                }
                break;
            case "Z":
                selfPoint = 3;
                if (ennemy.equals("A")) {
                    // lost
                } else if (ennemy.equals("B")) {
                    // win
                    roundPoint = 6;
                } else if (ennemy.equals("C")) {
                    // draw
                    roundPoint = 3;
                }
                break;
        }

        return roundPoint + selfPoint;


    }
}

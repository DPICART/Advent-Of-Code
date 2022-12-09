package fr.daart.y2022.ex01;

import fr.daart.y2022.AoC2022;

import java.util.ArrayList;

public class AoC202201 extends AoC2022 {

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public void part1() {
        var input = readInput("input.txt");
        int currentElfCalories = 0;
        var calories = new ArrayList<Integer>();

        for (var line : input) {
            if (line.isEmpty()) {
                calories.add(currentElfCalories);
                currentElfCalories = 0;
                continue;
            }
            currentElfCalories += Integer.parseInt(line);
        }

        calories.sort((a, b) -> a > b ? -1 : 1);

        int top = calories.get(0);
        System.out.println("Part 1: " + top);
    }

    @Override
    public void part2() {
        var input = readInput("input.txt");
        int currentElfCalories = 0;
        var calories = new ArrayList<Integer>();

        for (var line : input) {
            if (line.isEmpty()) {
                calories.add(currentElfCalories);
                currentElfCalories = 0;
                continue;
            }
            currentElfCalories += Integer.parseInt(line);
        }

        calories.sort((a, b) -> a > b ? -1 : 1);

        int top3 = calories.get(0) + calories.get(1) + calories.get(2);
        System.out.println("Part 2: " + top3);
    }
}

package fr.daart.y2015.ex03;

import fr.daart.y2015.AoC2015;

import java.util.Arrays;
import java.util.HashSet;

public class AoC201503 extends AoC2015 {
    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public void part1() {
        var santa = new Santa();
        streamInput("input.txt").flatMap(item -> Arrays.stream(item.split(""))).forEachOrdered(santa::move);

        var result = santa.getHouseVisitedOnce();

        System.out.println("Part 1: "+result);
    }

@Override
    public void part2() {
    var santa = new Santa();
    var roboSanta = new Santa();

    var input = readInputAsString("input.txt").split("");

    for(int i = 0; i < input.length; i++) {
        var currentMove = input[i];
        if(i%2==0) {
            santa.move(currentMove);
        } else {
            roboSanta.move(currentMove);
        }
    }

    var visitedHouse = new HashSet<House>();

    visitedHouse.addAll(santa.getVisited());
    visitedHouse.addAll(roboSanta.getVisited());

    var result = visitedHouse.size();
    System.out.println("Part 2: "+result);
    }
}

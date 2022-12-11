package fr.daart.y2022.ex11;

import fr.daart.y2022.AoC2022;

import java.util.ArrayList;
import java.util.List;

public class AoC202211 extends AoC2022 {
    private List<Monkey> monkeys = new ArrayList<>();

    @Override
    public int getDay() {
        return 11;
    }

    @Override
    public void part1() {

        var rawMonkeys = readInputAsString("input.txt").split("\r\n\r\n");

        for (var rawMonkey : rawMonkeys) {
            var newMonkey = Monkey.fromString(rawMonkey);
            monkeys.add(newMonkey);
        }

        int roundToPerform = 20;

        for (int i = 0; i < roundToPerform; i++) {
            performARound();
            //printData(i + 1);
        }

        //printInspectionData();

        var topMonkeys = monkeys.stream().map(m -> m.getInspectionCount()).sorted((a, b) -> a < b ? 1 : -1).limit(2).toList();

        var result = topMonkeys.get(0) * topMonkeys.get(1);
        System.out.println("Part 1: " + result);
    }

    private void performARound() {
        this.performARound(true, 1L);
    }

    private void printInspectionData() {

        for (int i = 0; i < monkeys.size(); i++) {
            System.out.println("Monkey " + i + " inspected items " + monkeys.get(i).getInspectionCount() + " times.");
        }
        System.out.println();


    }

    private void printData(int currentRound) {

        System.out.println("After round " + currentRound + ", the monkeys are holding items with these worry levels:");
        for (var monkey : monkeys) {
            System.out.println(monkey.getName().trim() + " " + monkey.getStringItemsWorryLevels());
        }
        System.out.println();

    }

    private void performARound(boolean isBored, Long commonDivisor) {
        for (var monkey : monkeys) {
            var resultFromInspection = monkey.inspect(isBored, commonDivisor);
            for (var newItemHolder : resultFromInspection.keySet()) {
                monkeys.get(newItemHolder.intValue()).addItems(resultFromInspection.get(newItemHolder.longValue()));
            }
        }
    }

    @Override
    public void part2() {

        var rawMonkeys = readInputAsString("input.txt").split("\r\n\r\n");

        for (var rawMonkey : rawMonkeys) {
            var newMonkey = Monkey.fromString(rawMonkey);
            monkeys.add(newMonkey);
        }

        var commonDivisor = monkeys.stream().map(Monkey::getDivisor).reduce(1L, (a,b) -> a*b);

        //System.out.println("Common divisor between all monkeys' checks: "+commonDivisor);

        int roundToPerform = 10_000;

        for (int i = 0; i < roundToPerform; i++) {
            performARound(false, commonDivisor);
            //printDataPart2(i + 1);
        }

        var topMonkeys = monkeys.stream().map(m -> m.getInspectionCount()).sorted((a, b) -> a < b ? 1 : -1).limit(2).toList();

        var result = topMonkeys.get(0) * topMonkeys.get(1);
        System.out.println("Part 2: " + result);

    }

    private void printDataPart2(int round) {
        if(round == 1 || round == 20 || round % 1000 == 0) {
            System.out.println("== After round " + round + " ==");
            for (int i = 0; i < monkeys.size(); i++) {
                System.out.println("Monkey " + i + " inspected items " + monkeys.get(i).getInspectionCount() + " times.");
            }
            System.out.println();
        }
    }
}

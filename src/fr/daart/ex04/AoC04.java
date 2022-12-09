package fr.daart.ex04;

import fr.daart.AoC2022;

import java.util.Arrays;

public class AoC04 extends AoC2022 {


    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public void part1() {
        var input = readInput("input.txt");
        var inputSize = input.size();
        int overlapped = 0;
        for (String line : input) {
            var ranges = line.split(",");
            boolean overlap = doesOneRangeContainsTheOther(ranges[0], ranges[1]);
            //System.out.println(line + " : " + overlap);
            if (overlap) {
                overlapped++;
            }
        }
        System.out.println("Part 1: " + overlapped);
    }

    @Override
    public void part2() {
        var input = readInput("input.txt");
        int overlapped = 0;
        for (String line : input) {
            var ranges = line.split(",");
            var areOverlapping = areOverlapped(ranges[0], ranges[1]);
            //System.out.println(line + " overlapQuantity = " + areOverlapping);
            if (areOverlapping) {
                overlapped++;
            }
        }
        System.out.println("Part 2: " + overlapped);
    }

    private boolean areOverlapped(String range1String, String range2String) {

        int[] range1 = Arrays.stream(range1String.split("-")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] range2 = Arrays.stream(range2String.split("-")).mapToInt(Integer::parseInt).sorted().toArray();

        return (range1[0] >= range2[0] && range1[1] <= range2[1])
                || (range1[1] >= range2[0] && range1[1] <= range2[1])
                || (range2[0] >= range1[0] && range2[1] <= range1[1])
                || (range2[1] >= range1[0] && range2[1] <= range1[1]);
    }

    private boolean doesOneRangeContainsTheOther(String range1String, String range2String) {
        int[] range1 = Arrays.stream(range1String.split("-")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] range2 = Arrays.stream(range2String.split("-")).mapToInt(Integer::parseInt).sorted().toArray();
        return (range1[0] <= range2[0] && range1[1] >= range2[1])
                || (range1[0] >= range2[0] && range1[1] <= range2[1]);
    }


}

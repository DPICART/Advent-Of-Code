package fr.daart.y2015.ex01;

import fr.daart.y2015.AoC2015;

import java.util.Arrays;

public class AoC201501 extends AoC2015 {
    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public void part1() {
        var input = readInput("input.txt").get(0);
        Arrays
                .stream(input.split(""))
                .map(val -> switch (val) {
                            case "(" -> 1;
                            case ")" -> -1;
                            default -> 0;
                        }
                )
                .reduce(Integer::sum);

        var result = Arrays
                .stream(input.split(""))
                .map(val -> switch (val) {
                            case "(" -> 1;
                            case ")" -> -1;
                            default -> 0;
                        }
                )
                .reduce(Integer::sum)
                .get();
        System.out.println("Part 1: " + result);
    }

    @Override
    public void part2() {
        var input = readInput("input.txt").get(0);
        Arrays
                .stream(input.split(""))
                .map(val -> switch (val) {
                            case "(" -> 1;
                            case ")" -> -1;
                            default -> 0;
                        }
                )
                .reduce(Integer::sum);

        var list = Arrays
                .stream(input.split(""))
                .map(val -> switch (val) {
                            case "(" -> 1;
                            case ")" -> -1;
                            default -> 0;
                        }
                )
                .toList();

        var sum = 0;
        var index = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if(sum == -1) {
                index = i+1;
                break;
            }
        }
        System.out.println("Part 2: " + index);
    }
}

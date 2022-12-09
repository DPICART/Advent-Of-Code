package fr.daart.y2022.ex03;

import fr.daart.y2022.AoC2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC202203 extends AoC2022 {

    @Override
    public int getDay() {
        return 3;
    }

    /*
         a - z   A  -  Z
         1 - 26  27 - 52
        96 - 121 122- 147
        */
    private final static List<String> lettersArray = Arrays.stream("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")).toList();

    @Override
    public void part1() {

        int total = streamInput("input.txt")
                .map(value -> lettersArray.indexOf(getCommonLetter(value)))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Part 1: " + total);
    }

    @Override
    public void part2() {

        var input = readInput("input.txt");
        var inputLength = input.size();
        int total = 0;

        for (int i = 0; i < inputLength; i = i + 3) {

            var sack1 = input.get(i);
            var sack2 = input.get(i + 1);
            var sack3 = input.get(i + 2);

            String commonLetter = getCommonLetter(sack1, sack2, sack3);
            //System.out.println(i + "->" + (i + 2) + " - Common Item: " + commonLetter);
            int priority = lettersArray.indexOf(commonLetter);
            total += (priority + 1);
        }

        System.out.println("Part 2: " + total);
    }

    private String getCommonLetter(String sack1, String sack2, String sack3) {

        var list1 = Arrays.stream(sack1.split("")).toList();
        var list2 = Arrays.stream(sack2.split("")).toList();
        var list3 = Arrays.stream(sack3.split("")).toList();

        return list1
                .stream()
                .filter(item1 -> list2.stream().anyMatch(item2 -> item2.equals(item1)) && list3.stream().anyMatch(item3 -> item3.equals(item1)))
                .findFirst()
                .get();
    }


    private String getCommonLetter(String rucksack) {

        var itemList1 = new ArrayList<String>();
        var itemList2 = new ArrayList<String>();

        var compartmentSize = rucksack.length() / 2;
        var arr = rucksack.split("");
        for (int i = 0; i < arr.length; i++) {
            if (i < compartmentSize) {
                itemList1.add(arr[i]);
            } else {
                itemList2.add(arr[i]);
            }
        }

        for (int j = 0; j < compartmentSize; j++) {
            var itemFrom1 = itemList1.get(j);

            if (itemList2.contains(itemFrom1)) {
                return itemFrom1;
            }
        }

        return null;
    }
}

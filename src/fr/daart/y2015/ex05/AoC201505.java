package fr.daart.y2015.ex05;

import fr.daart.y2015.AoC2015;

import java.util.regex.Pattern;

public class AoC201505 extends AoC2015 {



    Pattern regexVoyel = Pattern.compile("/[aeiou]{3}/");
    Pattern regexDouble = Pattern.compile("(\\w{2})");
    Pattern regexExclud = Pattern.compile("(\\bab\\b)|(\\bcd\\b)|(\\bpq\\b)|(\\bxy\\b)");

    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");

        var result = 0;
        for(int i = 0; i < input.size(); i++) {
            if(isNice(input.get(i))) {
                result++;
            }
        }

        System.out.println("Part 1: "+result);
    }

    private boolean isNice(String input) {

        boolean vowel = false;
        boolean doubl = false;
        boolean exclu = false;

        return vowel && doubl && !exclu;
    }

    @Override
    public void part2() {
        //var result = "";
        //System.out.println("Part 2: "+result);
    }
}

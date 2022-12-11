package fr.daart.y2015.ex05;

import fr.daart.y2015.AoC2015;

import java.util.Arrays;
import java.util.List;

public class AoC201505 extends AoC2015 {


    private final List<String> vowels = List.of("a", "e", "i", "o", "u");
    private final List<String> forbiddenString = List.of("ab", "cd", "pq", "xy");

    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");

        var result = 0;
        for (int i = 0; i < input.size(); i++) {
            if (isNice(input.get(i))) {
                result++;
            }
        }

        System.out.println("Part 1: " + result);
    }

    private boolean isNice(String word) {

        var letters = word.split("");
        boolean itContains3Vowels = Arrays.stream(letters).filter(item -> vowels.contains(item)).count() >= 3;

        boolean itContainsALetterAppearingTwiceInARow = false;
        String[] buffer = new String[2];
        for (var letter : letters) {
            buffer[1] = buffer[0];
            buffer[0] = letter;
            if (buffer[0].equals(buffer[1])) {
                itContainsALetterAppearingTwiceInARow = true;
                break;
            }
        }

        boolean itDoesNotContainForbiddenStrings = forbiddenString.stream().noneMatch(forbiddenStuff -> word.contains(forbiddenStuff));

        return itContains3Vowels && itContainsALetterAppearingTwiceInARow && itDoesNotContainForbiddenStrings;
    }


    @Override
    public void part2() {

        var input = readInput("input.txt");

        var result = 0;
        for (int i = 0; i < input.size(); i++) {
            if (isNicer(input.get(i))) {
                result++;
            }
        }

        System.out.println("Part 2: " + result);
    }

    private boolean isNicer(String word) {
        var letters = word.split("");

        boolean itContainsAtLeastOneLetterBetweenSameLetters = false;
        for(int i = 0; i+2 < letters.length; i++) {
            if(letters[i].equals(letters[i+2])) {
                itContainsAtLeastOneLetterBetweenSameLetters = true;
                break;
            }
        }


        boolean itContainsAPairOfAnyTwoLettersTwice = false;
        for(int i = 0; i + 1 < letters.length; i++) {
            String pair = letters[i]+letters[i+1];
            if(word.substring(i+2).contains(pair)) {
                itContainsAPairOfAnyTwoLettersTwice = true;
                break;
            }
        }



        return itContainsAPairOfAnyTwoLettersTwice && itContainsAtLeastOneLetterBetweenSameLetters;

    }
}

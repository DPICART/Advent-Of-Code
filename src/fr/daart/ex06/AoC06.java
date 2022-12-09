package fr.daart.ex06;

import fr.daart.AoC2022;

import java.util.Arrays;

public class AoC06 extends AoC2022 {

    @Override
    public Class getClazz() {
        return this.getClass();
    }

    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public void part1() {

        var input = readInputAsString("input.txt");

        var letters = input.split("");

        var buffer = new String[4];
        var charactersProcessed = 0;

        for (int i = 3; i < letters.length; i++) {

            buffer[0] = letters[i - 3];
            buffer[1] = letters[i - 2];
            buffer[2] = letters[i - 1];
            buffer[3] = letters[i];

            if (bufferIsASequence(buffer)) {
                charactersProcessed = i + 1;
                break;
            }

        }

        System.out.println("Part 1: " + charactersProcessed);
    }

    @Override
    public void part2() {

        var input = readInputAsString("input.txt");

        var letters = input.split("");

        var bufferSize = 14;
        var buffer = new String[bufferSize];
        var charactersProcessed = 0;

        for (int i = bufferSize - 1; i < letters.length; i++) {

            for (int j = 0; j < bufferSize; j++) {
                buffer[j] = letters[i - j + 1];
            }

            if (bufferIsASequence2(buffer)) {
                charactersProcessed = i + 2;
                break;
            }

        }

        System.out.println("Part 2: " + charactersProcessed);
    }

    private boolean bufferIsASequence(String[] buffer) {

        return !buffer[0].equals(buffer[1])
                && !buffer[0].equals(buffer[2])
                && !buffer[0].equals(buffer[3])
                && !buffer[1].equals(buffer[2])
                && !buffer[1].equals(buffer[3])
                && !buffer[2].equals(buffer[3]);

    }

    private boolean bufferIsASequence2(String[] buffer) {

        return Arrays.asList(buffer).stream().distinct().count() == buffer.length;

    }
}

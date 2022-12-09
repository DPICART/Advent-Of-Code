package fr.daart;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public abstract class AoC {

    public abstract int getYear();

    public abstract int getDay();

    public abstract void part1();

    public abstract void part2();

    public void run() {
        System.out.println("\n == AoC" + getYear() + " Day #" + getDay() + " == \n");
        part1();
        part2();
    }

    protected abstract Path getResourcePath(String filename);

    protected List<String> readInput(String filename) {
        try {
            return Files.readAllLines(getResourcePath(filename), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String readInputAsString(String filename) {
        try {
            return new String(Files.readAllBytes(getResourcePath(filename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected Stream<String> streamInput(String filename) {
        try {
            return Files.lines(getResourcePath(filename)); // Leak here :-)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
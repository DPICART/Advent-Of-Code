package fr.daart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public abstract class AoC2022 {

    public abstract int getDay();

    public abstract void part1();

    public abstract void part2();

    public void run() {

        System.out.println("\n == Day " + getDay() + " == \n");
        part1();
        part2();
    }

    protected List<String> readInput(String filename) {
        try {
            return Files.readAllLines(Paths.get(this.getClass().getResource(filename).toURI()), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }

    protected BufferedReader iterateInput(String filename) {
        try {
            var file = new File(filename);
            var fr = new FileReader(file);
            return new BufferedReader(fr);
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }


    protected String readInputAsString(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(this.getClass().getResource(filename).toURI())));
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }

    protected Stream<String> streamInput(String filename) {
        try {
            return Files.lines(Paths.get(this.getClass().getResource(filename).toURI())); // Leak here :-)
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }
}

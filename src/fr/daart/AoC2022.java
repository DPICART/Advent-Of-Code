package fr.daart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public abstract class AoC2022 {

    public abstract int getDay();
    public abstract void part1();
    public abstract void part2();
    public abstract Class getClazz();

    public void run() {
        System.out.println("\n == Day " + getDay() + " == \n");
        part1();
        part2();
    }

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

    private Path getResourcePath(String filename) {
        try {
            var resource = getClazz().getResource(filename);
            var uri = resource.toURI();
            return Paths.get(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

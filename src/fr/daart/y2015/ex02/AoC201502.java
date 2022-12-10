package fr.daart.y2015.ex02;

import fr.daart.y2015.AoC2015;

import java.util.ArrayList;

public class AoC201502 extends AoC2015 {
    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public void part1() {

        var result = streamInput("input.txt")
                .map(line -> {
                    // l w h
                    var splitted = line.split("x");
                    var l = Integer.parseInt(splitted[0]);
                    var w = Integer.parseInt(splitted[1]);
                    var h = Integer.parseInt(splitted[2]);

                    var slide1 = l * w;
                    var slide2 = w * h;
                    var slide3 = h * l;

                    var minSlide = Math.min(slide1, Math.min(slide2, slide3));

                    return 2 * (slide1 + slide2 + slide3) + minSlide;
                })
                .reduce(Integer::sum)
                .get();
        System.out.println("Part 1: " + result);
    }

    @Override
    public void part2() {
        var result = streamInput("input.txt")
                .map(line -> {
                    // l w h
                    var splitted = line.split("x");
                    var l = Integer.parseInt(splitted[0]);
                    var w = Integer.parseInt(splitted[1]);
                    var h = Integer.parseInt(splitted[2]);

                    Integer maxSide = Math.max(l, Math.max(w, h));
                    var minSides = new ArrayList<Integer>() {{
                        add(l);
                        add(w);
                        add(h);
                    }};

                    minSides.remove(maxSide);
                    var wrap = 2 * minSides.stream().reduce(Integer::sum).get();
                    return (l * w * h) + wrap;
                })
                .reduce(Integer::sum)
                .get();
        System.out.println("Part 2: " + result);
    }
}

package fr.daart.ex05;

import fr.daart.AoC2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class AoC05 extends AoC2022 {


    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public void part1() {

        var ship = new LinkedList<String>();
        var moves = new LinkedList<String>();

        AtomicBoolean isShip = new AtomicBoolean(true);
        streamInput("input.txt").forEachOrdered(line -> {
            if (line.equals("")) {
                isShip.set(false);
            } else {
                if (isShip.get()) {
                    ship.add(line);
                } else {
                    moves.add(line);
                }
            }
        });

        var cargo = createCargoFromInput(ship);

        moveCargoContainers(cargo, moves);

        List<String> topContainers = getTopContainers(cargo);

        System.out.println("Part 1: " + topContainers.toString().replace("[", "").replace("]", "").replace(" ", "").replace(",", ""));
    }

    @Override
    public void part2() {

        var ship = new LinkedList<String>();
        var moves = new LinkedList<String>();

        AtomicBoolean isShip = new AtomicBoolean(true);
        streamInput("input.txt").forEachOrdered(line -> {
            if (line.equals("")) {
                isShip.set(false);
            } else {
                if (isShip.get()) {
                    ship.add(line);
                } else {
                    moves.add(line);
                }
            }
        });

        var cargo = createCargoFromInput(ship);

        moveCargoContainersCrateMover9001(cargo, moves);

        List<String> topContainers = getTopContainers(cargo);

        System.out.println("Part 2: " + topContainers.toString().replace("[", "").replace("]", "").replace(" ", "").replace(",", ""));
    }

    private List<String> getTopContainers(Map<Integer, LinkedList<String>> cargo) {
        return cargo.values().stream().map(list -> list.get(list.size() - 1)).collect(Collectors.toList());
    }

    private void moveCargoContainers(Map<Integer, LinkedList<String>> cargo, List<String> moves) {
        for (var move : moves) {
            int[] values = getValuesFromMovement(move);
            applyMoveToCargo(cargo, values[0], values[1], values[2]);
        }
    }

    private void applyMoveToCargo(Map<Integer, LinkedList<String>> cargo, int quantity, int sourceIndex, int targetIndex) {

        var source = cargo.get(sourceIndex - 1);
        var target = cargo.get(targetIndex - 1);

        for (int qty = 0; qty < quantity; qty++) {

            if (source.size() > 0) {
                var topElement = source.remove(source.size() - 1);
                target.add(topElement);
            }

        }
        cargo.put(sourceIndex - 1, source);
        cargo.put(targetIndex - 1, target);
    }

    private int[] getValuesFromMovement(String move) {
        int[] values = new int[3];

        values[0] = Integer.parseInt(move.split("from")[0].replace("move", "").replace(" ", ""));
        String secondPart = move.split("from")[1];
        var thirdPart = secondPart.split("to");
        values[1] = Integer.parseInt(thirdPart[0].replace(" ", ""));
        values[2] = Integer.parseInt(thirdPart[1].replace(" ", ""));

        return values;
    }

    private Map<Integer, LinkedList<String>> createCargoFromInput(List<String> ship) {
        var newCargo = new HashMap<Integer, LinkedList<String>>();
        var toto = ship.get(ship.size() - 1).replace(" ", "");
        int cargoWidth = Integer.parseInt(toto.substring(toto.length() - 1));
        for (int i = ship.size() - 2; i >= 0; i--) {
            var currentLine = ship.get(i);
            var lineLength = currentLine.length();
            for (int j = 0; j < cargoWidth && (j * 4 + 3) <= lineLength; j++) {
                var currentCargoLine = newCargo.getOrDefault(j, new LinkedList<>());
                var stringIndexStart = j * 4;
                var stringIndexEnd = stringIndexStart + 3;
                var container = currentLine.substring(stringIndexStart, stringIndexEnd).replace(" ", "");
                if (container.length() > 0) {
                    currentCargoLine.add(container);
                }
                newCargo.put(j, currentCargoLine);
            }
        }
        return newCargo;
    }

    private void moveCargoContainersCrateMover9001(Map<Integer, LinkedList<String>> cargo, LinkedList<String> moves) {

        for (var move : moves) {
            int[] values = getValuesFromMovement(move);
            applyMoveToCargo9001(cargo, values[0], values[1], values[2]);

        }

    }

    private void applyMoveToCargo9001(Map<Integer, LinkedList<String>> cargo, int quantity, int sourceIndex, int targetIndex) {

        var source = cargo.get(sourceIndex - 1);
        var target = cargo.get(targetIndex - 1);

        List moved = new LinkedList<String>();
        for (int qty = 0; qty < quantity; qty++) {
            if (source.size() > 0) {
                var topElement = source.remove(source.size() - 1);
                moved.add(topElement);
            }
        }

        Collections.reverse(moved);
        target.addAll(moved);

        cargo.put(sourceIndex - 1, source);
        cargo.put(targetIndex - 1, target);
    }

}

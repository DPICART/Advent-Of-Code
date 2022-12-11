package fr.daart.y2015.ex06;

import java.util.function.Function;

public abstract class P2Instruction {
    public P2Instruction(int fromX, int fromY, int toX, int toY) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    private int fromX;
    private int fromY;
    private int toX;
    private int toY;

    public static P2Instruction from(String line) {

        if (line.startsWith(P2TurnOn.NAME)) {
            var tmp = line.replace(P2TurnOn.NAME, "").split(" through ");
            var from = tmp[0].split(",");
            var to = tmp[1].split(",");
            return new P2TurnOn(
                    Integer.parseInt(from[0]),
                    Integer.parseInt(from[1]),
                    Integer.parseInt(to[0]),
                    Integer.parseInt(to[1])
            );
        } else if (line.startsWith(P2Toggle.NAME)) {
            var tmp = line.replace(P2Toggle.NAME, "").split(" through ");
            var from = tmp[0].split(",");
            var to = tmp[1].split(",");
            return new P2Toggle(
                    Integer.parseInt(from[0]),
                    Integer.parseInt(from[1]),
                    Integer.parseInt(to[0]),
                    Integer.parseInt(to[1])
            );
        } else if (line.startsWith(P2TurnOff.NAME)) {
            var tmp = line.replace(P2TurnOff.NAME, "").split(" through ");
            var from = tmp[0].split(",");
            var to = tmp[1].split(",");
            return new P2TurnOff(
                    Integer.parseInt(from[0]),
                    Integer.parseInt(from[1]),
                    Integer.parseInt(to[0]),
                    Integer.parseInt(to[1])
            );
        } else {
            throw new IllegalArgumentException("Invalid Instruction");
        }

    }

    public abstract Function<Long, Long> getFunction();

    public void applyOn(long[][] lights) {
        for (int y = fromY; y < toY+1; y++) {
            for (int x = fromX; x < toX+1; x++) {
                var newState = getFunction().apply(lights[y][x]);
                //System.out.println("Light " + x + "," + y + " went from " + lights[y][x] + " to " + newState);
                lights[y][x] = newState;
            }
        }
    }
}

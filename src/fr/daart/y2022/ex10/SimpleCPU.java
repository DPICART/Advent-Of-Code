package fr.daart.y2022.ex10;

import java.util.ArrayList;
import java.util.List;

public class SimpleCPU {
    private int register = 1;
    private int cycle = 1;
    private String[][] CRT = new String[6][39];
    List<Instruction> instructions = new ArrayList<>();

    public List<Integer> getPart1Stored() {
        return part1Stored;
    }

    List<Integer> part1Stored = new ArrayList<>();

    public void addInstruction(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public boolean isWorking() {
        return this.instructions.size() > 0;
    }

    public void tick() {



        var spritePosition = register;
        var positionCRT = (cycle% 40) - 1;
        if(positionCRT < 0) {
            positionCRT += 20;
        }
        var lineCRT = Math.floorDiv(cycle-1, 40);
        var renderedString = (spritePosition - 1 <= positionCRT && positionCRT <= spritePosition + 1) ? "#" : " ";
        CRT[lineCRT][positionCRT] = renderedString;

        cycle++;
        var currentInstruction = instructions.get(0);
        currentInstruction.execute();
        if (currentInstruction.isComplete()) {
            if (currentInstruction instanceof AddxInstruction) {
                this.register += currentInstruction.getValue();
            }
            instructions.remove(currentInstruction);
        }
        if (cycle == 20 || (cycle - 20) % 40 == 0) {
            part1Stored.add(cycle * register);
        }
    }

    public int getRegister() {
        return register;
    }

    public int getCycle() {
        return cycle;
    }

    public String getCRTImage() {

        var sb = new StringBuilder();

        sb.append("\n");

        for (var lines : CRT) {

            for (var pixel : lines) {
                sb.append(pixel);
            }
            sb.append("\n");

        }
        return sb.toString();

    }
}

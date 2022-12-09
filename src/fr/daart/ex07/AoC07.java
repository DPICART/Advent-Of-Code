package fr.daart.ex07;

import fr.daart.AoC2022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AoC07 extends AoC2022 {

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    public void part1() {

        var input = readInput("input.txt");
        String lastCmd = null;

        Dossier root = new Dossier("/", 0, null);
        Dossier currentDir = root;

        for (int i = 0; i < input.size(); i++) {
            var currentLine = input.get(i);

            boolean isACmdLine = currentLine.startsWith("$ ");
            if (isACmdLine) {
                var shortCmd = currentLine.replace("$ ", "");
                var cmd = shortCmd.split(" ");
                switch (cmd[0]) {
                    case "ls":
                        lastCmd = "ls";
                        break;
                    case "cd":
                        if (cmd[1].equals("/")) {
                            currentDir = root;
                        } else if (cmd[1].equals("..")) {
                            currentDir = currentDir.getParent();
                        } else {
                            currentDir = currentDir.goToDir(cmd[1]);
                        }
                        lastCmd = "cd";
                        break;
                }
            } else if (lastCmd.equals("ls")) {
                var response = currentLine.split(" ");
                switch (response[0]) {
                    case "dir":
                        currentDir.putDossier(response[1]);
                        break;
                    default:
                        currentDir.putFichier(response[0], response[1]);
                        break;
                }
            }
        }

        //System.out.println(root);

        List<Dossier> fatDirs = findFatDirs(root);

        var sumThinDirs = fatDirs.stream().map(Dossier::getSize).reduce((a, b) -> a + b).orElse(0L);

        System.out.println("Part 1: " + sumThinDirs);
    }

    @Override
    public void part2() {

        var input = readInput("input.txt");
        String lastCmd = null;

        Dossier root = new Dossier("/", 0, null);
        Dossier currentDir = root;

        for (int i = 0; i < input.size(); i++) {
            var currentLine = input.get(i);

            boolean isACmdLine = currentLine.startsWith("$ ");
            if (isACmdLine) {
                var shortCmd = currentLine.replace("$ ", "");
                var cmd = shortCmd.split(" ");
                switch (cmd[0]) {
                    case "ls":
                        lastCmd = "ls";
                        break;
                    case "cd":
                        if (cmd[1].equals("/")) {
                            currentDir = root;
                        } else if (cmd[1].equals("..")) {
                            currentDir = currentDir.getParent();
                        } else {
                            currentDir = currentDir.goToDir(cmd[1]);
                        }
                        lastCmd = "cd";
                        break;
                }
            } else if (lastCmd.equals("ls")) {
                var response = currentLine.split(" ");
                switch (response[0]) {
                    case "dir":
                        currentDir.putDossier(response[1]);
                        break;
                    default:
                        currentDir.putFichier(response[0], response[1]);
                        break;
                }
            }
        }

        //System.out.println(root);

        var totalSpace = 70_000_000L;
        var neededSpace = 30_000_000L;
        var usedSpace = root.getSize();

        var spaceToDelete = usedSpace - (totalSpace - neededSpace);

        List<Long> dirs = findDirsBiggerThan(root, spaceToDelete).stream().map(Dossier::getSize).sorted().toList();

        System.out.println("Part 2: " + dirs.get(0));
    }

    private List<Dossier> findFatDirs(Dossier currentFolder) {

        List<Dossier> result = new ArrayList<>();

        Collection<Dossier> subDirs = currentFolder.getSubDirs();

        List<Dossier> fatSubDirs = subDirs.stream().filter(dossier -> dossier.getSize() < 100000).collect(Collectors.toList());

        result.addAll(fatSubDirs);

        for (var subDir : subDirs) {
            result.addAll(findFatDirs(subDir));
        }

        return result;

    }

    private List<Dossier> findDirsBiggerThan(Dossier currentFolder, long maxValue) {

        List<Dossier> result = new ArrayList<>();

        Collection<Dossier> subDirs = currentFolder.getSubDirs();

        List<Dossier> fatSubDirs = subDirs.stream().filter(dossier -> dossier.getSize() >= maxValue).collect(Collectors.toList());

        result.addAll(fatSubDirs);

        for (var subDir : subDirs) {
            result.addAll(findDirsBiggerThan(subDir, maxValue));
        }

        return result;

    }

}

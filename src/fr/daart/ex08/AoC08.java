package fr.daart.ex08;

import fr.daart.AoC2022;

import java.util.ArrayList;

public class AoC08 extends AoC2022 {

    @Override
    public Class getClazz() {
        return this.getClass();
    }

    @Override
    public int getDay() {
        return 8;
    }

    @Override
    public void part1() {
        var input = readInput("input.txt");

        var forest = new ArrayList<Tree>();
        var topTrees = new ArrayList<Tree>();
        for (String currentLine : input) {

            var splitted = currentLine.split("");

            var trees = new ArrayList<Tree>();
            Tree leftTree = null;
            for (int x = 0; x < splitted.length; x++) {

                var currentTreeHeight = Integer.parseInt(splitted[x]);
                var topTree = topTrees.size() > x ? topTrees.get(x) : null;
                var currentTree = new Tree(currentTreeHeight, leftTree, topTree);
                if (null != topTree) {
                    topTree.setBottomTree(currentTree);
                }
                if (null != leftTree) {
                    leftTree.setRightTree(currentTree);
                }
                trees.add(currentTree);
                leftTree = currentTree;
            }
            forest.addAll(trees);
            topTrees = trees;
        }


        var seen = forest.stream().filter(Tree::canBeSeen).toList();

        System.out.println("Part 1: " + seen.size());
    }

    @Override
    public void part2() {
        var input = readInput("input.txt");
        var forest = new ArrayList<Tree>();
        var topTrees = new ArrayList<Tree>();
        for (String currentLine : input) {

            var splitted = currentLine.split("");

            var trees = new ArrayList<Tree>();
            Tree leftTree = null;
            for (int x = 0; x < splitted.length; x++) {

                var currentTreeHeight = Integer.parseInt(splitted[x]);
                var topTree = topTrees.size() > x ? topTrees.get(x) : null;
                var currentTree = new Tree(currentTreeHeight, leftTree, topTree);
                if (null != topTree) {
                    topTree.setBottomTree(currentTree);
                }
                if (null != leftTree) {
                    leftTree.setRightTree(currentTree);
                }
                trees.add(currentTree);
                leftTree = currentTree;
            }
            forest.addAll(trees);
            topTrees = trees;
        }


        var seen = forest.stream().map(Tree::getScenicScore).sorted().toList();

        System.out.println("Part 2: " + seen.get(seen.size() - 1));
    }
}

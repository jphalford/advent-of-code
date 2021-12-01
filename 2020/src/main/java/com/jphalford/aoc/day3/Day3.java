package com.jphalford.aoc.day3;

import java.util.List;
import java.util.stream.IntStream;

public class Day3 {
    public long solvePart1(List<String> expenseReport) {
        return calculateNumTrees(expenseReport, 1, 3);
    }

    public long solvePart2(List<String> expenseReport) {
        return calculateNumTrees(expenseReport, 1, 1) *
                calculateNumTrees(expenseReport, 1, 3) *
                calculateNumTrees(expenseReport, 1, 5) *
                calculateNumTrees(expenseReport, 1, 7) *
                calculateNumTrees(expenseReport, 2, 1);
    }

    private long calculateNumTrees(List<String> map, int yMove, int xMove) {
        return IntStream.range(0, map.size())
                .filter(y -> y % yMove == 0)
                .map(y -> map.get(y).charAt((y/yMove * xMove) % map.get(0).length()))
                .filter(c -> c == '#')
                .count();
    }
}

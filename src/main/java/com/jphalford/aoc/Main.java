package com.jphalford.aoc;

import com.jphalford.aoc.day1.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        day1();
    }

    private static void day1() throws IOException {
        List<String> expenseReport = Files.readAllLines(Paths.get("data/day1/part1.txt"));
        Day1 day1 = new Day1();
        reportResult(1, 1, day1.solvePart1(expenseReport).toPlainString());
        reportResult(1, 2, day1.solvePart2(expenseReport).toPlainString());
    }

    private static void reportResult(int day, int part, String result) {
        System.out.printf("Day %2d, Part: %d, Result: %s%n", day, part, result);
    }
}

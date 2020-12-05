package com.jphalford.aoc;

import com.jphalford.aoc.day1.ExpenseReportRepairer;
import com.jphalford.aoc.day2.Day2;
import com.jphalford.aoc.day3.Day3;
import com.jphalford.aoc.util.InputReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        day1();
        day2();
        day3();
    }


    private static void day1() throws IOException {
        List<String> expenseReport = InputReader.forDay(1);
        ExpenseReportRepairer expenseReportRepairer = new ExpenseReportRepairer();
        reportResult(1, 1, expenseReportRepairer.solvePart1BruteForce(expenseReport).toPlainString());
        reportResult(1, 1, expenseReportRepairer.solvePart1BruteForceStreams(expenseReport).toPlainString());
        reportResult(1, 1, expenseReportRepairer.solvePart1Optimised(expenseReport).toPlainString());
        reportResult(1, 2, expenseReportRepairer.solvePart2(expenseReport).toPlainString());
    }

    private static void day2() throws IOException {
        List<String> passwordReport = InputReader.forDay(2);
        Day2 day2 = new Day2();
        reportResult(2, 1, Long.toString(day2.solvePart1(passwordReport)));
        reportResult(2, 2, Long.toString(day2.solvePart2(passwordReport)));
    }

    private static void day3() throws IOException {
        List<String> passwordReport = InputReader.forDay(3);
        Day3 day3 = new Day3();
        reportResult(3, 1, Long.toString(day3.solvePart1(passwordReport)));
        reportResult(3, 2, Long.toString(day3.solvePart2(passwordReport)));
    }

    private static void reportResult(int day, int part, String result) {
        System.out.printf("Day %2d, Part: %d, Result: %s%n", day, part, result);
    }
}

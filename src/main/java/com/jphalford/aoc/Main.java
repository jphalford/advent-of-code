package com.jphalford.aoc;

import com.jphalford.aoc.day1.ExpenseReportRepairer;
import com.jphalford.aoc.day2.Day2;
import com.jphalford.aoc.day3.Day3;
import com.jphalford.aoc.day4.Day4;
import com.jphalford.aoc.day5.Day5;
import com.jphalford.aoc.day6.Day6;
import com.jphalford.aoc.util.InputReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        day1();
//        day2();
//        day3();
//        day4();
//        day5();
        day6();
    }


    private static void day1() throws IOException {
        List<String> expenseReport = InputReader.allLinesForDay(1);
        ExpenseReportRepairer expenseReportRepairer = new ExpenseReportRepairer();
        reportResult(1, 1, expenseReportRepairer.solvePart1BruteForce(expenseReport).toPlainString());
        reportResult(1, 1, expenseReportRepairer.solvePart1BruteForceStreams(expenseReport).toPlainString());
        reportResult(1, 1, expenseReportRepairer.solvePart1Optimised(expenseReport).toPlainString());
        reportResult(1, 2, expenseReportRepairer.solvePart2(expenseReport).toPlainString());
    }

    private static void day2() throws IOException {
        List<String> passwordReport = InputReader.allLinesForDay(2);
        Day2 day2 = new Day2();
        reportResult(2, 1, Long.toString(day2.solvePart1(passwordReport)));
        reportResult(2, 2, Long.toString(day2.solvePart2(passwordReport)));
    }

    private static void day3() throws IOException {
        List<String> passwordReport = InputReader.allLinesForDay(3);
        Day3 day3 = new Day3();
        reportResult(3, 1, Long.toString(day3.solvePart1(passwordReport)));
        reportResult(3, 2, Long.toString(day3.solvePart2(passwordReport)));
    }

    private static void day4() throws IOException {
        Day4 day4 = new Day4();
        CharStream passportData = CharStreams.fromPath(InputReader.pathForDay(4));
        reportResult(4, 1, Long.toString(day4.solvePart1(passportData)));
        reportResult(4, 2, Long.toString(day4.solvePart2(passportData)));
    }

    private static void day5() throws IOException {
        Day5 day5 = new Day5();
        List<String> seatCodes = InputReader.allLinesForDay(5);
        reportResult(5, 1, Integer.toString(day5.solvePart1(seatCodes)));
        reportResult(5, 2, Long.toString(day5.solvePart2(seatCodes)));
    }

    private static void day6() throws IOException {
        Day6 day6 = new Day6();
        reportResult(6, 1, Long.toString(day6.solvePart1(InputReader.charStreamForDay(6))));
        reportResult(6, 2, Long.toString(day6.solvePart2(InputReader.charStreamForDay(6))));
    }

    private static void reportResult(int day, int part, String result) {
        System.out.printf("Day %2d, Part: %d, Result: %s%n", day, part, result);
    }
}

package com.jphalford.aoc.day10;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    Day10 day10 = new Day10();

    @Test
    void part1Example1() {
        assertEquals(220, day10.solvePart1(asList(
                "28",
                "33",
                "18",
                "42",
                "31",
                "14",
                "46",
                "20",
                "48",
                "47",
                "24",
                "23",
                "49",
                "45",
                "19",
                "38",
                "39",
                "11",
                "1",
                "32",
                "25",
                "35",
                "8",
                "17",
                "7",
                "9",
                "4",
                "2",
                "34",
                "10",
                "3")));
    }

//    @Test
//    void part2MyExample() {
//        assertEquals(, day10.solvePart2(asList(
//                "1",
//                "2",
//                "3",
//                "4")));
//    }

    @Test
    void part2Example1() {
        assertEquals(8, day10.solvePart2(asList(
                "16",
                "10",
                "15",
                "5",
                "1",
                "11",
                "7",
                "19",
                "6",
                "12",
                "4")));
    }

    @Test
    void part2Example2() {
        assertEquals(19208, day10.solvePart2(asList(
                "28",
                "33",
                "18",
                "42",
                "31",
                "14",
                "46",
                "20",
                "48",
                "47",
                "24",
                "23",
                "49",
                "45",
                "19",
                "38",
                "39",
                "11",
                "1",
                "32",
                "25",
                "35",
                "8",
                "17",
                "7",
                "9",
                "4",
                "2",
                "34",
                "10",
                "3")));
    }
}
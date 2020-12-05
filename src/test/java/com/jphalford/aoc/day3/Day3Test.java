package com.jphalford.aoc.day3;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private final Day3 day3 = new Day3();

    @Test
    void oneMoveNoTrees() {
        assertEquals(0, day3.solvePart1(asList(
                "....",
                "....")));
    }

    @Test
    void oneMoveOneTree() {
        assertEquals(1, day3.solvePart1(asList(
                "....",
                "####")));
    }


    @Test
    void twoMoveNoTreesSameMap() {
        assertEquals(0, day3.solvePart1(asList(
                "........",
                "........",
                "........")));
    }

    @Test
    void twoMoveOneTreeSameMap() {
        assertEquals(1, day3.solvePart1(asList(
                "........",
                "........",
                "....####")));
    }

    @Test
    void threeMoveOneTreeTwoMap() {
        assertEquals(1, day3.solvePart1(asList(
                "........",
                "........",
                "....####",
                "........")));
    }
}
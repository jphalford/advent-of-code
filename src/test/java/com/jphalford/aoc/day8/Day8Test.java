package com.jphalford.aoc.day8;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {

    Day8 day8 = new Day8();


    @Test
    void onlyNoOp() {
        assertEquals(0, day8.solvePart1(asList(
                "nop +0",
                "jmp -1"
        )));
    }

    @Test
    void onlyOneAcc() {
        assertEquals(1, day8.solvePart1(asList(
                "acc +1",
                "jmp -1"
        )));
    }

    @Test
    void multipleAcc() {
        assertEquals(7, day8.solvePart1(asList(
                "acc +10",
                "acc -3",
                "jmp -1"
        )));
    }

    @Test
    void multipleJump() {
        assertEquals(20, day8.solvePart1(asList(
                "acc +10",
                "jmp +2",
                "acc +10",
                "acc +10",
                "jmp -3")));
    }

    @Test
    void example() {
        assertEquals(5, day8.solvePart1(asList(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6")));
    }

    @Test
    void examplePart2() {
        assertEquals(8, day8.solvePart2(asList(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6")));
    }
}

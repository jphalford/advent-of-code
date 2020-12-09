package com.jphalford.aoc.day9;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class XMASCrackerTest {

    @Test
    void part1Example() {
        XMASCracker xmasCracker = new XMASCracker(5);
        assertEquals(127, xmasCracker.findFirstInvalid(asList(
                35L,
                20L,
                15L,
                25L,
                47L,
                40L,
                62L,
                55L,
                65L,
                95L,
                102L,
                117L,
                150L,
                182L,
                127L,
                219L,
                299L,
                277L,
                309L,
                576L)));
    }

    @Test
    void part2Example() {
        XMASCracker xmasCracker = new XMASCracker(5);
        assertEquals(62, xmasCracker.findWeakness(asList(
                35L,
                20L,
                15L,
                25L,
                47L,
                40L,
                62L,
                55L,
                65L,
                95L,
                102L,
                117L,
                150L,
                182L,
                127L,
                219L,
                299L,
                277L,
                309L,
                576L)));
    }
}
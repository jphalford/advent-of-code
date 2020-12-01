package com.jphalford.aoc.day1;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

public class Day1Test {

    private Day1 day1;

    @Test
    void simplestCase() {
        final BigDecimal solution = day1.solvePart1(asList("2020", "1"));
        assertEqualByComparingTo(BigDecimal.valueOf(2020), solution);
    }

    private static void assertEqualByComparingTo(BigDecimal expected, BigDecimal actual) {

    }
}

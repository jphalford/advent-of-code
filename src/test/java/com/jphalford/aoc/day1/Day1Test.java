package com.jphalford.aoc.day1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Day 1")
class Day1Test {

    private final Day1 day1 = new Day1();

    @Nested
    @DisplayName("Part 1")
    class Part1 {
        @Test
        void invalidExpenses() {
            assertThrows(IllegalArgumentException.class, () -> day1.solvePart1(emptyList()));
        }

        @Test
        void simplestCase() {
            final BigDecimal solution = day1.solvePart1(asList("2019", "1"));
            assertThat(BigDecimal.valueOf(2019), comparesEqualTo(solution));
        }

        @Test
        void notAllNumbersAddTo2020() {
            final BigDecimal solution = day1.solvePart1(asList("20", "1", "2000"));
            assertThat(BigDecimal.valueOf(40000), comparesEqualTo(solution));
        }

        @Test
        void exampleExpenseReport() {
            final BigDecimal solution = day1.solvePart1(asList("1721", "979", "366", "299", "675", "1456"));
            assertThat(BigDecimal.valueOf(514579), comparesEqualTo(solution));
        }
    }

    @Nested
    @DisplayName("Part 2")
    class Part2 {
        @Test
        void invalidExpenses() {
            assertThrows(IllegalArgumentException.class, () -> day1.solvePart2(emptyList()));
        }

        @Test
        void simplestCase() {
            final BigDecimal solution = day1.solvePart2(asList("2015", "2", "3"));
            assertThat(BigDecimal.valueOf(12_090), comparesEqualTo(solution));
        }

        @Test
        void notAllNumbersAddTo2020() {
            final BigDecimal solution = day1.solvePart2(asList("20", "2", "2000", "18"));
            assertThat(BigDecimal.valueOf(72_000), comparesEqualTo(solution));
        }
    }
}

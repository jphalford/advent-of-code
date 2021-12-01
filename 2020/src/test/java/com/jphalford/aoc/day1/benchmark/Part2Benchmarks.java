package com.jphalford.aoc.day1.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;


public class Part2Benchmarks {
    private static final BigDecimal PART2_EXPECTED = new BigDecimal("85491920");

    @Benchmark
    public void part2BruteForce(ExpenseReportBenchmarkState state) {
        assertThat(state.getExpenseReportSolver()
                        .solvePart2(state.getExpenseReport()),
                comparesEqualTo(PART2_EXPECTED));
    }

    @Benchmark
    public void part2Optimised(ExpenseReportBenchmarkState state) {
        assertThat(state.getExpenseReportSolver()
                        .solvePart2Optimised(state.getExpenseReport()),
                comparesEqualTo(PART2_EXPECTED));
    }
}

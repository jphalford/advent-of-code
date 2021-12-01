package com.jphalford.aoc.day1.benchmark;

import org.hamcrest.Matchers;
import org.openjdk.jmh.annotations.Benchmark;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;


public class Part1Benchmarks {
    private static final BigDecimal PART1_EXPECTED = new BigDecimal("138379");


    @Benchmark
    public void part1BruteForce(ExpenseReportBenchmarkState state) {
        assertThat(state.getExpenseReportSolver()
                        .solvePart1BruteForce(state.getExpenseReport()),
                Matchers.comparesEqualTo(PART1_EXPECTED));
    }

    @Benchmark
    public void part1BruteForceStreams(ExpenseReportBenchmarkState state) {
        assertThat(state.getExpenseReportSolver()
                        .solvePart1BruteForceStreams(state.getExpenseReport()),
                Matchers.comparesEqualTo(PART1_EXPECTED));
    }

    @Benchmark
    public void part1Optimised(ExpenseReportBenchmarkState state) {
        assertThat(state.getExpenseReportSolver()
                        .solvePart1Optimised(state.getExpenseReport()),
                Matchers.comparesEqualTo(PART1_EXPECTED));
    }
}

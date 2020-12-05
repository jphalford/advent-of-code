package com.jphalford.aoc.day1;

import com.jphalford.aoc.day1.benchmark.Part1Benchmarks;
import com.jphalford.aoc.day1.benchmark.Part2Benchmarks;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

@Tag("benchmark")
public class ExpenseReportBenchmarkTest {
    @Test
    public void part1Benchmark() throws RunnerException {
        runBenchmark(Part1Benchmarks.class);
    }

    @Test
    public void part2Benchmark() throws RunnerException {
        runBenchmark(Part2Benchmarks.class);
    }

    private void runBenchmark(Class<?> benchmarkClass) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(benchmarkClass.getName())
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(6)
                .threads(1)
                .measurementIterations(6)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(options).run();
    }
}

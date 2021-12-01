package com.jphalford.aoc.day1.benchmark;

import com.jphalford.aoc.day1.ExpenseReportRepairer;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@State(Scope.Thread)
public class ExpenseReportBenchmarkState {
    private List<String> expenseReport;
    private ExpenseReportRepairer expenseReportRepairer;

    @Setup(Level.Trial)
    public void setUpBenchmark() throws IOException {
        expenseReport = Files.readAllLines(Paths.get("data/day1/part1.txt"));
        expenseReportRepairer = new ExpenseReportRepairer();
    }

    public List<String> getExpenseReport() {
        return expenseReport;
    }

    public ExpenseReportRepairer getExpenseReportSolver() {
        return expenseReportRepairer;
    }
}
package com.jphalford.aoc.day1;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    private static final BigDecimal TARGET_AMOUNT = BigDecimal.valueOf(2020);

    public BigDecimal solvePart1(List<String> expenseReport) {
        List<BigDecimal> expenses = convertExpenseReport(expenseReport);

        for (BigDecimal expense1 : expenses) {
            for (BigDecimal expense2 : expenses) {
                if (TARGET_AMOUNT.compareTo(expense1.add(expense2)) == 0) {
                    return expense1.multiply(expense2);
                }
            }
        }

        throw new IllegalArgumentException("Expenses report must have 2 values that add to " + TARGET_AMOUNT.toPlainString());
    }

    public BigDecimal solvePart2(List<String> expenseReport) {
        List<BigDecimal> expenses = convertExpenseReport(expenseReport);

        for (BigDecimal expense1 : expenses) {
            for (BigDecimal expense2 : expenses) {
                for (BigDecimal expense3: expenses) {
                    if (TARGET_AMOUNT.compareTo(expense1.add(expense2).add(expense3)) == 0) {
                        return expense1.multiply(expense2).multiply(expense3);
                    }
                }
            }
        }

        throw new IllegalArgumentException("Expenses report must have 3 values that add to " + TARGET_AMOUNT.toPlainString());
    }

    private List<BigDecimal> convertExpenseReport(List<String> expenseReport) {
        return expenseReport.stream().map(BigDecimal::new).collect(Collectors.toList());
    }

}

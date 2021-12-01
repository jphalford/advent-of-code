package com.jphalford.aoc.day1;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ExpenseReportRepairer {
    private static final BigDecimal TARGET_AMOUNT = BigDecimal.valueOf(2020);

    public BigDecimal solvePart1BruteForce(List<String> expenseReport) {
        List<BigDecimal> expenses = convertExpenseReportToList(expenseReport);

        for (BigDecimal expense1 : expenses) {
            for (BigDecimal expense2 : expenses) {
                if (expense1 != expense2 &&
                        TARGET_AMOUNT.compareTo(expense1.add(expense2)) == 0) {
                    return expense1.multiply(expense2);
                }
            }
        }

        throw newPart1IllegalExpenseReportException();
    }

    public BigDecimal solvePart1BruteForceStreams(List<String> expenseReport) {
        List<BigDecimal> expenses = convertExpenseReportToList(expenseReport);
        return expenses.stream()
                .map(expense1 -> expenses.stream()
                        .filter(expense2 -> expense1 != expense2 &&
                                TARGET_AMOUNT.compareTo(expense1.add(expense2)) == 0)
                        .map(expense1::multiply)
                        .findFirst())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(ExpenseReportRepairer::newPart1IllegalExpenseReportException);
    }

    public BigDecimal solvePart1Optimised(List<String> expenseReport) {
        TreeSet<BigDecimal> expensesSet = convertExpenseReportToTreeSet(expenseReport);
        return findEntryMeetingTarget(expensesSet, TARGET_AMOUNT)
                .map(ExpenseEntries::expenseProduct)
                .orElseThrow(ExpenseReportRepairer::newPart1IllegalExpenseReportException);
    }


    public BigDecimal solvePart2(List<String> expenseReport) {
        List<BigDecimal> expenses = convertExpenseReportToList(expenseReport);

        for (BigDecimal expense1 : expenses) {
            for (BigDecimal expense2 : expenses) {
                for (BigDecimal expense3 : expenses) {
                    if (TARGET_AMOUNT.compareTo(expense1.add(expense2).add(expense3)) == 0) {
                        return expense1.multiply(expense2).multiply(expense3);
                    }
                }
            }
        }

        throw newPart2IllegalExpenseReportException();
    }

    public BigDecimal solvePart2Optimised(List<String> expenseReport) {
        TreeSet<BigDecimal> expensesSet = convertExpenseReportToTreeSet(expenseReport);
        return expensesSet.stream()
                .map(expense -> createExpenseEntriesForTargetAmount(expensesSet, expense, TARGET_AMOUNT))
                .filter(entry -> !entry.isRemainderToTargetMet())
                .map(entry -> Pair.of(entry, findEntryMeetingTarget(expensesSet, entry.remainderToTarget)))
                .filter(p -> p.right.isPresent())
                .findFirst()
                .map(p -> p.left.firstEntry.multiply(p.right.get().expenseProduct()))
                .orElseThrow(ExpenseReportRepairer::newPart2IllegalExpenseReportException);
    }


    private static Optional<ExpenseEntries> findEntryMeetingTarget(TreeSet<BigDecimal> expensesSet, BigDecimal target) {
        return expensesSet.stream()
                .map(expense -> createExpenseEntriesForTargetAmount(expensesSet, expense, target))
                .filter(ExpenseEntries::isRemainderToTargetMet)
                .findFirst();
    }

    private static List<BigDecimal> convertExpenseReportToList(List<String> expenseReport) {
        return expenseReport.stream().map(BigDecimal::new).collect(Collectors.toList());
    }

    private static TreeSet<BigDecimal> convertExpenseReportToTreeSet(List<String> expenseReport) {
        return expenseReport.stream().map(BigDecimal::new).collect(Collectors.toCollection(TreeSet::new));
    }

    private static ExpenseEntries createExpenseEntriesForTargetAmount(TreeSet<BigDecimal> expensesSet, BigDecimal firstEntry, BigDecimal targetAmount) {
        BigDecimal remainder = targetAmount.subtract(firstEntry);
        return ExpenseEntries.builder()
                .firstEntry(firstEntry)
                .remainderToTarget(remainder)
                .secondEntry(expensesSet.ceiling(remainder))
                .build();
    }

    private static IllegalArgumentException newPart1IllegalExpenseReportException() {
        return new IllegalArgumentException("Expenses report must have 2 values that add to " + TARGET_AMOUNT.toPlainString());
    }

    private static IllegalArgumentException newPart2IllegalExpenseReportException() {
        return new IllegalArgumentException("Expenses report must have 3 values that add to " + TARGET_AMOUNT.toPlainString());
    }

    @Value()
    @Builder
    private static class ExpenseEntries {
        BigDecimal firstEntry;
        BigDecimal remainderToTarget;
        BigDecimal secondEntry;

        boolean isRemainderToTargetMet() {
            return secondEntry != null && firstEntry != secondEntry &&
                    remainderToTarget.compareTo(secondEntry) == 0;
        }

        BigDecimal expenseProduct() {
            return firstEntry.multiply(secondEntry);
        }
    }

    @Value(staticConstructor = "of")
    private static class Pair<L, R> {
        L left;
        R right;
    }

}

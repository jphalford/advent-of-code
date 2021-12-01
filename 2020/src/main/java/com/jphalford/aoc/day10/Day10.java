package com.jphalford.aoc.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    public static final int CHARGER_JOLTAGE = 0;
    public static final int MAX_JOLTAGE_DIFF = 3;

    public long solvePart1(List<String> encodedString) {
        List<Long> sortedInput = encodedString.stream().map(Long::parseLong).sorted().collect(Collectors.toList());

        int num1Diff = 0;
        int num3Diff = 0;
        long lastJoltage = CHARGER_JOLTAGE;

        for (Long adapterJoltage : sortedInput) {
            long diff = adapterJoltage - lastJoltage;
            if (diff == 1) {
                num1Diff++;
            } else if (diff == 3) {
                num3Diff++;
            }
            lastJoltage = adapterJoltage;
        }
        num3Diff++;

        return num1Diff * num3Diff;
    }


    public long solvePart2(List<String> encodedString) {
        List<Long> sortedInput = encodedString.stream().map(Long::parseLong).sorted().collect(Collectors.toList());
        sortedInput.add(sortedInput.get(sortedInput.size()-1) + MAX_JOLTAGE_DIFF);
        long[] visitedCache = new long[sortedInput.size()];
        Arrays.fill(visitedCache, -1L);
        return backtrack(sortedInput, sortedInput.size()-1, visitedCache);
    }

    long backtrack(List<Long> adapters, int index, long[] visitedCache) {
        long currentAdapterJoltage = adapters.get(index);
        long numValidPaths = 0;

        if (currentAdapterJoltage - MAX_JOLTAGE_DIFF <= CHARGER_JOLTAGE) {
            numValidPaths++;
        }

        int minIndex = Math.max(0, index - MAX_JOLTAGE_DIFF);
        for (int recIndex = index-1; recIndex >= minIndex; recIndex--) {
            long recAdapterJoltage = adapters.get(recIndex);
            if (currentAdapterJoltage - recAdapterJoltage <=MAX_JOLTAGE_DIFF) {
                if (visitedCache[recIndex] >= 0) {
                    numValidPaths += visitedCache[recIndex];
                } else {
                    numValidPaths += backtrack(adapters, recIndex, visitedCache);
                }
            }
        }

        visitedCache[index] = numValidPaths;

        return numValidPaths;
    }
}

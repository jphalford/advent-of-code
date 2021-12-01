package com.jphalford.aoc.day9;

import java.util.List;
import java.util.TreeSet;

public class XMASCracker {
    private final int preambleSize;
    private final EvictingTreeSet<Long> preamble;

    public XMASCracker(int preambleSize) {
        this.preambleSize = preambleSize;
        this.preamble = new EvictingTreeSet<>(preambleSize);
    }

    public long findFirstInvalid(List<Long> encodedData) {
        int i = 0;

        for (; i < preambleSize; i++) {
            preamble.add(encodedData.get(i));
        }

        for (; i < encodedData.size(); i++) {
            Long nextValue = encodedData.get(i);
            if (isInvalid(nextValue)) {
                break;
            }
            preamble.add(nextValue);
        }

        return encodedData.get(i);
    }

    public long findWeakness(List<Long> encodedData) {
        long firstInvalid = this.findFirstInvalid(encodedData);
        boolean foundSum = false;
        int lowerBound = 0;
        int upperBound = 0;

        for (; lowerBound < encodedData.size() && !foundSum; lowerBound++) {
            long contiguousSum = encodedData.get(lowerBound);
            for (upperBound = lowerBound+1; upperBound < encodedData.size() && !foundSum; upperBound++) {
                contiguousSum += encodedData.get(upperBound);
                if (contiguousSum == firstInvalid) {
                    foundSum = true;
                } else if (contiguousSum > firstInvalid) {
                    break;
                }
            }
        }
        lowerBound--;

        TreeSet<Long> boundedData = new TreeSet<>(encodedData.subList(lowerBound, upperBound));
        return boundedData.first() + boundedData.last();
    }

    private boolean isInvalid(Long nextValue) {
        return preamble.stream()
                .noneMatch(preambleValue -> this.sumOfAnotherPreambleValueEqual(preambleValue, nextValue));
    }

    private boolean sumOfAnotherPreambleValueEqual(Long preambleValue, Long nextValue) {
        Long target = nextValue - preambleValue;
        return preamble.contains(target);
    }
}

package com.jphalford.aoc.day5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BinarySpacePartitionDecoder {
    private final char upperHalfMarker;

    public int decode(String bspString) {
        int numBits = bspString.length();
        int result = 0;

        for (int i = 0; i < numBits; i++) {
            if (bspString.charAt(i) == upperHalfMarker) {
                result |= 1 << (numBits - i - 1);
            }
        }

        return result;
    }
}

package com.jphalford.aoc.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySpacePartitionDecoderTest {
    private static final char UPPER_HALF = 'U';
    private static final char LOWER_HALF = 'L';
    private BinarySpacePartitionDecoder decoder = new BinarySpacePartitionDecoder(UPPER_HALF);

    @Test
    void oneUpperChar() {
        assertEquals(1, decoder.decode("U"));
    }

    @Test
    void oneLowerChar() {
        assertEquals(0, decoder.decode("L"));
    }

    @Test
    void oneUpperOneLowerChar() {
        assertEquals(2, decoder.decode("UL"));
    }

    @Test
    void twoUpperChar() {
        assertEquals(3, decoder.decode("UU"));
    }

    @Test
    void example() {
        BinarySpacePartitionDecoder decoder = new BinarySpacePartitionDecoder(UPPER_HALF);
        assertEquals(5, decoder.decode("ULU"));
    }
}
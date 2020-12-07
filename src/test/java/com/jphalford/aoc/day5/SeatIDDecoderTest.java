package com.jphalford.aoc.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatIDDecoderTest {

    SeatIDDecoder seatIDDecoder = new SeatIDDecoder();

    @Test
    void examples() {
        assertAll(
                () -> assertEquals(357, seatIDDecoder.decodeSeatId("FBFBBFFRLR")),
                () -> assertEquals(567, seatIDDecoder.decodeSeatId("BFFFBBFRRR")),
                () -> assertEquals(119, seatIDDecoder.decodeSeatId("FFFBBBFRRR")),
                () -> assertEquals(820, seatIDDecoder.decodeSeatId("BBFFBBFRLL"))
        );
    }
}
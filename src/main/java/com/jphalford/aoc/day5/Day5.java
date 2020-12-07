package com.jphalford.aoc.day5;

import java.util.Arrays;
import java.util.List;

import static com.jphalford.aoc.day5.SeatIDDecoder.MAX_SEAT_ID;

public class Day5 {

    public int solvePart1(List<String> seatCodes) {
        SeatIDDecoder seatIDDecoder = new SeatIDDecoder();

        return seatCodes.stream()
                .map(seatIDDecoder::decodeSeatId)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("Could not find max seat ID"));
    }


    public int solvePart2(List<String> seatCodes) {
        SeatIDDecoder seatIDDecoder = new SeatIDDecoder();
        boolean[] seatsOccupied = new boolean[MAX_SEAT_ID];
        Arrays.fill(seatsOccupied, false);

        for (String seatCode : seatCodes) {
            seatsOccupied[seatIDDecoder.decodeSeatId(seatCode)] = true;
        }

        for (int i = 0; i < seatsOccupied.length; i++) {
            if (!seatsOccupied[i] && seatsOccupied[i+1] && seatsOccupied[i-1]) {
                return i;
            }
        }

        throw new IllegalArgumentException("Could not find empty seat");
    }
}

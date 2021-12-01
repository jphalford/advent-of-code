package com.jphalford.aoc.day5;

public class SeatIDDecoder {
    private static final int ROW_COL_BOUNDARY_INDEX = 7;
    private static final int NUM_SEATS_PER_ROW = 8;
    private static final int NUM_ROWS = 128;
    public static final int MAX_SEAT_ID = NUM_ROWS * NUM_SEATS_PER_ROW;

    private final BinarySpacePartitionDecoder rowDecoder = new BinarySpacePartitionDecoder('B');
    private final BinarySpacePartitionDecoder colDecoder = new BinarySpacePartitionDecoder('R');

    public int decodeSeatId(String seatCode) {
        return rowDecoder.decode(getRowCode(seatCode)) * NUM_SEATS_PER_ROW + colDecoder.decode(getColCode(seatCode));
    }

    private String getColCode(String seatCode) {
        return seatCode.substring(ROW_COL_BOUNDARY_INDEX);
    }

    private String getRowCode(String seatCode) {
        return seatCode.substring(0, ROW_COL_BOUNDARY_INDEX);
    }
}

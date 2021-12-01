package com.jphalford.aoc.day9;

import java.util.List;
import java.util.stream.Collectors;

public class Day9 {

    public long solvePart1(List<String> encodedString) {
        List<Long> encoded = encodedString.stream().map(Long::parseLong).collect(Collectors.toList());
        XMASCracker xmasCracker = new XMASCracker(25);
        return xmasCracker.findFirstInvalid(encoded);
    }


    public long solvePart2(List<String> encodedString) {
        List<Long> encoded = encodedString.stream().map(Long::parseLong).collect(Collectors.toList());
        XMASCracker xmasCracker = new XMASCracker(25);
        return xmasCracker.findWeakness(encoded);
    }
}

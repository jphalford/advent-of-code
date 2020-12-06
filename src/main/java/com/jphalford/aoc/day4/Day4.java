package com.jphalford.aoc.day4;

import com.jphalford.aoc.day4.parser.AntlrPassportDataParser;
import org.antlr.v4.runtime.CharStream;

import java.util.function.Predicate;

public class Day4 {
    public long solvePart1(CharStream passportData) {
        Part1PassportValidator validator = new Part1PassportValidator();
        return solve(passportData, validator);
    }

    public long solvePart2(CharStream passportData) {
        Part2PassportValidator validator = new Part2PassportValidator();
        return solve(passportData, validator);
    }

    private long solve(CharStream passportData, Predicate<PassportData> validator) {
        return new AntlrPassportDataParser()
                .parse(passportData)
                .stream()
                .filter(validator)
                .count();
    }
}

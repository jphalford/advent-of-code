package com.jphalford.aoc.day6;

import com.jphalford.aoc.day6.parser.AntlrCustomsDeclarationDataParser;
import org.antlr.v4.runtime.CharStream;

import java.util.function.ToLongFunction;

public class Day6 {
    public long solvePart1(CharStream passportData) {
        return solve(passportData, new AnyoneAnsweredCounter()::count);
    }

    public long solvePart2(CharStream passportData) {
        return solve(passportData, new EveryoneAnsweredCounter()::count);
    }

    private long solve(CharStream passportData, ToLongFunction<GroupDeclarationData> counter) {
        AntlrCustomsDeclarationDataParser parser = new AntlrCustomsDeclarationDataParser();
        return parser.parse(passportData)
                .getGroupDeclarationDatas()
                .stream()
                .mapToLong(counter)
                .sum();
    }
}

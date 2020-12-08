package com.jphalford.aoc.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class InputReader {
    private InputReader() {

    }

    public static CharStream charStreamForDay(int dayNum) throws IOException {
        return CharStreams.fromPath(pathForDay(dayNum));
    }

    public static Path pathForDay(int dayNum) {
        return Paths.get("data")
                .resolve(Integer.toString(dayNum))
                .resolve("input.txt");
    }

    public static List<String> allLinesForDay(int dayNum) throws IOException {
        return Files.readAllLines(pathForDay(dayNum));
    }
}

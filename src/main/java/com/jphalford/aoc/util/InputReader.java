package com.jphalford.aoc.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class InputReader {
    private InputReader() {

    }

    public static List<String> forDay(int dayNum) throws IOException {
        return Files.readAllLines(Paths.get("data")
                .resolve(Integer.toString(dayNum))
                .resolve("input.txt"));
    }
}

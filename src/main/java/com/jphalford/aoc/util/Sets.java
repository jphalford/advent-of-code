package com.jphalford.aoc.util;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public final class Sets {

    private Sets() {

    }

    public static <T> Set<T> asSet(T... values) {
        return new HashSet<>(asList(values));
    }
}

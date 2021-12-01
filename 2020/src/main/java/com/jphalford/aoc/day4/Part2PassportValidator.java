package com.jphalford.aoc.day4;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2PassportValidator implements Predicate<PassportData> {
    private static final Pattern HAIR_PATTERN = Pattern.compile("#[0-9a-f]{6}");
    private static final Pattern PASSPORT_NUM_PATTERN = Pattern.compile("[0-9]{9}");
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("([0-9]+)(cm|in)");

    @Override
    public boolean test(PassportData passportData) {
        return new Part1PassportValidator()
                .and(p -> {
                    int byr = Integer.parseInt(p.getBirthYear());
                    return byr >= 1920 && byr <= 2002;
                })
                .and(p -> {
                    int iyr = Integer.parseInt(p.getIssueYear());
                    return iyr >= 2010 && iyr <= 2020;
                })
                .and(p -> {
                    int eyr = Integer.parseInt(p.getExpirationYear());
                    return eyr >= 2020 && eyr <= 2030;
                })
                .and(p -> {
                    Matcher heightMatcher = HEIGHT_PATTERN.matcher(p.getHeight());
                    if (heightMatcher.matches()) {
                        String heightUnit = heightMatcher.group(2);
                        long heightMeaurement = Long.parseLong(heightMatcher.group(1));
                        if ("in".equals(heightUnit)) {
                            return heightMeaurement >= 59 && heightMeaurement <= 76;
                        } else if ("cm".equals(heightUnit)) {
                            return heightMeaurement >= 150 && heightMeaurement <= 193;
                        }
                    }
                    return false;
                })
                .and(p -> HAIR_PATTERN.matcher(p.getHairColor()).matches())
                .and(p -> {
                    switch (p.getEyeColor()) {
                        case "amb":
                        case "blu":
                        case "brn":
                        case "gry":
                        case "grn":
                        case "hzl":
                        case "oth":
                            return true;
                        default:
                            return false;
                    }
                })
                .and(p -> PASSPORT_NUM_PATTERN.matcher(p.getPassportId()).matches())
                .test(passportData);
    }
}

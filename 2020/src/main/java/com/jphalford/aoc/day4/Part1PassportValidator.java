package com.jphalford.aoc.day4;

import java.util.function.Predicate;

public class Part1PassportValidator implements Predicate<PassportData> {

    @Override
    public boolean test(PassportData passportData) {
        return passportData.getBirthYear() != null &&
                passportData.getIssueYear() != null &&
                passportData.getExpirationYear() != null &&
                passportData.getHeight() != null &&
                passportData.getHairColor() != null &&
                passportData.getEyeColor() != null &&
                passportData.getPassportId() != null;
    }
}

package com.jphalford.aoc.day4;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PassportData {
    String birthYear;
    String issueYear;
    String expirationYear;
    String height;
    String hairColor;
    String eyeColor;
    String passportId;
    String countryId;
}

package com.jphalford.aoc.day4.parser;

import com.jphalford.aoc.day4.PassportData;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AntlrPassportDataParserTest {
    private static final String EXAMPLE_BATCH_FILE =
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\r\n" +
                    "byr:1937 iyr:2017 cid:147 hgt:183cm\r\n" +
                    "\r\n" +
                    "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\r\n" +
                    "hcl:#cfa07d byr:1929\r\n" +
                    "\r\n";

    @Test
    void testGrammar() {
        AntlrPassportDataParser antlrPassportDataParser = new AntlrPassportDataParser();

        assertEquals(asList(PassportData.builder()
                        .eyeColor("gry")
                        .passportId("860033327")
                        .expirationYear("2020")
                        .hairColor("#fffffd")
                        .birthYear("1937")
                        .issueYear("2017")
                        .countryId("147")
                        .height("183cm")
                        .build(),
                PassportData.builder()
                        .issueYear("2013")
                        .eyeColor("amb")
                        .countryId("350")
                        .expirationYear("2023")
                        .passportId("028048884")
                        .hairColor("#cfa07d")
                        .birthYear("1929")
                        .build()),
                antlrPassportDataParser.parse(CharStreams.fromString(EXAMPLE_BATCH_FILE)));
    }
}
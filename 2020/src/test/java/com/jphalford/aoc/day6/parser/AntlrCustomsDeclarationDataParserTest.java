package com.jphalford.aoc.day6.parser;

import com.jphalford.aoc.day6.FlightDeclarationData;
import com.jphalford.aoc.day6.GroupDeclarationData;
import com.jphalford.aoc.day6.PersonDeclaration;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

import static com.jphalford.aoc.util.Sets.asSet;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AntlrCustomsDeclarationDataParserTest {
    private static final String EXAMPLE_BATCH_FILE =
            "abc\n" +
                    "\n" +
                    "a\n" +
                    "b\n" +
                    "c\n" +
                    "\n" +
                    "ab\n" +
                    "ac\n";

    @Test
    void testGrammar() {
        AntlrCustomsDeclarationDataParser parser = new AntlrCustomsDeclarationDataParser();
        assertEquals(FlightDeclarationData.builder()
                        .groupDeclarationData(
                                GroupDeclarationData.builder()
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(asSet('a', 'b', 'c'))
                                                .build())
                                        .build())
                        .groupDeclarationData(
                                GroupDeclarationData.builder()
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(singleton('a'))
                                                .build())
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(singleton('b'))
                                                .build())
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(singleton('c'))
                                                .build())
                                        .build())
                        .groupDeclarationData(
                                GroupDeclarationData.builder()
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(asSet('a', 'b'))
                                                .build())
                                        .personDeclaration(PersonDeclaration.builder()
                                                .yesAnswers(asSet('a', 'c'))
                                                .build())
                                        .build())
                        .build(),


                parser.parse(CharStreams.fromString(EXAMPLE_BATCH_FILE)));
    }
}
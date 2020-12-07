package com.jphalford.aoc.day6;

import org.junit.jupiter.api.Test;

import static com.jphalford.aoc.util.Sets.asSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EveryoneAnsweredCounterTest {
    private EveryoneAnsweredCounter counter = new EveryoneAnsweredCounter();

    @Test
    void onePersonTwoAnswers() {
        assertEquals(2, counter.count(GroupDeclarationData.builder()
                .personDeclaration(PersonDeclaration.builder()
                        .yesAnswers(asSet('a', 'b'))
                        .build())
                .build()));
    }

    @Test
    void twoPeopleNoOverlappingAnswer() {
        assertEquals(0, counter.count(GroupDeclarationData.builder()
                .personDeclaration(PersonDeclaration.builder()
                        .yesAnswers(asSet('a', 'd'))
                        .build())
                .personDeclaration(PersonDeclaration.builder()
                        .yesAnswers(asSet('b', 'c'))
                        .build())
                .build()));
    }

    @Test
    void twoPeopleOneOverlappingAnswer() {
        assertEquals(1, counter.count(GroupDeclarationData.builder()
                .personDeclaration(PersonDeclaration.builder()
                        .yesAnswers(asSet('a', 'b'))
                        .build())
                .personDeclaration(PersonDeclaration.builder()
                        .yesAnswers(asSet('b', 'c'))
                        .build())
                .build()));
    }
}
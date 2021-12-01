package com.jphalford.aoc.day2.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CorporatePasswordPolicyConverterTest {

    private final CorporatePasswordPolicyConverter corporatePasswordPolicyConverter = new CorporatePasswordPolicyConverter();

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "1- a: a",
            "-1 a: a",
            "-1 a a"
    })
    void invalidFormat(String policyString) {
        assertThrows(IllegalArgumentException.class,
                () -> corporatePasswordPolicyConverter.convertPolicy(policyString));
    }

    @Test
    void oneCharExample() {
        CorporatePolicyAndPassword policy = corporatePasswordPolicyConverter.convertPolicy("1-1 a: a");
        assertAll(
                () -> assertEquals(1, policy.getMinOccur()),
                () -> assertEquals(1, policy.getMaxOccur()),
                () -> assertEquals('a', policy.getMandatoryChar()),
                () -> assertEquals("a", policy.getPassword())
        );
    }

    @Test
    void multiCharExample() {
        CorporatePolicyAndPassword policy = corporatePasswordPolicyConverter.convertPolicy("1-3 a: abAcd");
        assertAll(
                () -> assertEquals(1, policy.getMinOccur()),
                () -> assertEquals(3, policy.getMaxOccur()),
                () -> assertEquals('a', policy.getMandatoryChar()),
                () -> assertEquals("abAcd", policy.getPassword())
        );
    }

    @Test
    void numbersLargerThan9() {
        CorporatePolicyAndPassword policy = corporatePasswordPolicyConverter.convertPolicy("19-21 a: a");
        assertAll(
                () -> assertEquals(19, policy.getMinOccur()),
                () -> assertEquals(21, policy.getMaxOccur()),
                () -> assertEquals('a', policy.getMandatoryChar()),
                () -> assertEquals("a", policy.getPassword())
        );
    }
}
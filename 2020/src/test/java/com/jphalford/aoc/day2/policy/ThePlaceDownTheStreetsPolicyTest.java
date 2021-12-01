package com.jphalford.aoc.day2.policy;

import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThePlaceDownTheStreetsPolicyTest {
    private final ThePlaceDownTheStreetsPolicy policy = new ThePlaceDownTheStreetsPolicy();

    @Test
    void validSingleChar() {
        assertTrue(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(1)
                .maxOccur(1)
                .mandatoryChar('a')
                .password("a")
                .build()));
    }

    @Test
    void invalidSingleChar() {
        assertFalse(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(1)
                .maxOccur(1)
                .mandatoryChar('a')
                .password("b")
                .build()));
    }

    @Test
    void invalidLessThanMin() {
        assertFalse(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(2)
                .maxOccur(3)
                .mandatoryChar('a')
                .password("a")
                .build()));
    }

    @Test
    void invalidMoreThanMin() {
        assertFalse(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(2)
                .maxOccur(3)
                .mandatoryChar('a')
                .password("aaaa")
                .build()));
    }

    @Test
    void validEqualToMax() {
        assertTrue(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(2)
                .maxOccur(4)
                .mandatoryChar('a')
                .password("aaaa")
                .build()));
    }

    @Test
    void validEqualToMin() {
        assertTrue(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(2)
                .maxOccur(4)
                .mandatoryChar('a')
                .password("aa")
                .build()));
    }

    @Test
    void validMixedChars() {
        assertTrue(policy.isPasswordCompliant(CorporatePolicyAndPassword.builder()
                .minOccur(2)
                .maxOccur(4)
                .mandatoryChar('a')
                .password("aAbasdD")
                .build()));
    }
}
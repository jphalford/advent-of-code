package com.jphalford.aoc.day2.policy;

import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TheOfficialTobogganCompanyPolicyTest {

    private final TheOfficialTobogganCompanyPolicy policy = new TheOfficialTobogganCompanyPolicy();

    @Test
    void invalidNoMatches() {
        assertFalse(policy.isPasswordCompliant(
                CorporatePolicyAndPassword.builder()
                        .minOccur(1)
                        .maxOccur(2)
                        .mandatoryChar('a')
                        .password("bb")
                        .build()));
    }

    @Test
    void invalidTwoMatches() {
        assertFalse(policy.isPasswordCompliant(
                CorporatePolicyAndPassword.builder()
                        .minOccur(1)
                        .maxOccur(2)
                        .mandatoryChar('a')
                        .password("aa")
                        .build()));
    }

    @Test
    void validFirstMatches() {
        assertTrue(policy.isPasswordCompliant(
                CorporatePolicyAndPassword.builder()
                        .minOccur(1)
                        .maxOccur(2)
                        .mandatoryChar('a')
                        .password("ab")
                        .build()));
    }

    @Test
    void validSecondMatches() {
        assertTrue(policy.isPasswordCompliant(
                CorporatePolicyAndPassword.builder()
                        .minOccur(1)
                        .maxOccur(2)
                        .mandatoryChar('a')
                        .password("ba")
                        .build()));
    }
}
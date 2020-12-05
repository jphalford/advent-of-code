package com.jphalford.aoc.day2;

import com.jphalford.aoc.day2.input.CorporatePasswordPolicyConverter;
import com.jphalford.aoc.day2.policy.CorporatePolicyValidator;
import com.jphalford.aoc.day2.policy.TheOfficialTobogganCompanyPolicy;
import com.jphalford.aoc.day2.policy.ThePlaceDownTheStreetsPolicy;

import java.util.List;

public class Day2 {
    public long solvePart1(List<String> passwordPolicyInput) {
        return solve(passwordPolicyInput, new ThePlaceDownTheStreetsPolicy());
    }

    public long solvePart2(List<String> passwordPolicyInput) {
        return solve(passwordPolicyInput, new TheOfficialTobogganCompanyPolicy());
    }

    private long solve(List<String> passwordPolicyInput, CorporatePolicyValidator policyValidator) {
        CompliantPasswordCounter compliantPasswordCounter = new CompliantPasswordCounter(new CorporatePasswordPolicyConverter(), policyValidator);
        return compliantPasswordCounter.numCompliantPasswords(passwordPolicyInput);
    }
}

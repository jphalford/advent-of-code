package com.jphalford.aoc.day2;

import com.jphalford.aoc.day2.input.CorporatePasswordPolicyConverter;
import com.jphalford.aoc.day2.policy.CorporatePolicyValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompliantPasswordCounter {
    private final CorporatePasswordPolicyConverter converter;
    private final CorporatePolicyValidator validator;

    public long numCompliantPasswords(List<String> policyAndPasswords) {
        return policyAndPasswords.stream()
                .map(converter::convertPolicy)
                .filter(validator::isPasswordCompliant)
                .count();
    }
}

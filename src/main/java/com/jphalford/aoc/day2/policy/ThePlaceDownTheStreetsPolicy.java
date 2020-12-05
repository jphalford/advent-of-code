package com.jphalford.aoc.day2.policy;

import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;

public class ThePlaceDownTheStreetsPolicy implements CorporatePolicyValidator {
    @Override
    public boolean isPasswordCompliant(CorporatePolicyAndPassword corporatePolicyAndPassword) {
        long mandatoryCharCount = corporatePolicyAndPassword.getPassword()
                .chars()
                .filter(c -> c == corporatePolicyAndPassword.getMandatoryChar())
                .count();
        return mandatoryCharCount >= corporatePolicyAndPassword.getMinOccur() &&
                mandatoryCharCount <= corporatePolicyAndPassword.getMaxOccur();
    }
}

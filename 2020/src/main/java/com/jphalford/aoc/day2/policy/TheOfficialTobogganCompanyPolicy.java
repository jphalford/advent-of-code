package com.jphalford.aoc.day2.policy;

import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;

public class TheOfficialTobogganCompanyPolicy implements CorporatePolicyValidator {
    @Override
    public boolean isPasswordCompliant(CorporatePolicyAndPassword corporatePolicyAndPassword) {
        return corporatePolicyAndPassword.getPassword().charAt(corporatePolicyAndPassword.getMinOccur() - 1) == corporatePolicyAndPassword.getMandatoryChar() ^
                corporatePolicyAndPassword.getPassword().charAt(corporatePolicyAndPassword.getMaxOccur() - 1) == corporatePolicyAndPassword.getMandatoryChar();
    }
}

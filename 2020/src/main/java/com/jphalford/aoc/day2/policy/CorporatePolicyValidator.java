package com.jphalford.aoc.day2.policy;

import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;

@FunctionalInterface
public interface CorporatePolicyValidator {

    boolean isPasswordCompliant(CorporatePolicyAndPassword corporatePolicyAndPassword);

}

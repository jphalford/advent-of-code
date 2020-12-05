package com.jphalford.aoc.day2.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorporatePasswordPolicyConverter {
    private static final Pattern CORPORATE_PASSWORD_POLICY_PATTERN =
            Pattern.compile("(?<minOccur>\\d+)-(?<maxOccur>\\d+) (?<mandatoryChar>\\w): (?<password>\\w+)");

    public CorporatePolicyAndPassword convertPolicy(String policy) {
        Matcher matcher = CORPORATE_PASSWORD_POLICY_PATTERN.matcher(policy);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid policy: " + policy);
        }

        return new CorporatePolicyAndPassword(
                Integer.parseInt(matcher.group("minOccur")),
                Integer.parseInt(matcher.group("maxOccur")),
                matcher.group("mandatoryChar").charAt(0),
                matcher.group("password"));
    }
}

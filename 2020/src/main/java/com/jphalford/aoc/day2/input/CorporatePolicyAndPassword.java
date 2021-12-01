package com.jphalford.aoc.day2.input;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CorporatePolicyAndPassword {
    int minOccur;
    int maxOccur;
    char mandatoryChar;
    String password;
}

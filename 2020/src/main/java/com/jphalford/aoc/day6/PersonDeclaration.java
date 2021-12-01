package com.jphalford.aoc.day6;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class PersonDeclaration {
    Set<Character> yesAnswers;
}

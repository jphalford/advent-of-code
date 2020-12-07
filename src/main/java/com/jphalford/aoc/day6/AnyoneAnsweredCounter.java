package com.jphalford.aoc.day6;

import java.util.Set;
import java.util.stream.Collectors;

public class AnyoneAnsweredCounter {
    public long count(GroupDeclarationData groupDeclarationData) {
        return groupDeclarationData.getPersonDeclarations()
                .stream()
                .map(PersonDeclaration::getYesAnswers)
                .flatMap(Set::stream)
                .collect(Collectors.toSet())
                .size();
    }
}

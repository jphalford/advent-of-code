package com.jphalford.aoc.day6;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EveryoneAnsweredCounter {
    public long count(GroupDeclarationData groupDeclarationData) {
        int numPeopleInGroup = groupDeclarationData.getPersonDeclarations().size();
        return groupDeclarationData.getPersonDeclarations()
                .stream()
                .map(PersonDeclaration::getYesAnswers)
                .flatMap(Set::stream)
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == numPeopleInGroup)
                .count();
    }
}

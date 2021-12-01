package com.jphalford.aoc.day6;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GroupDeclarationData {
    @Singular
    List<PersonDeclaration> personDeclarations;
}

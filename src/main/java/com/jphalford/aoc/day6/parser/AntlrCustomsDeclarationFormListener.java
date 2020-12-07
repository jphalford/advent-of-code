package com.jphalford.aoc.day6.parser;

import com.jphalford.aoc.day6.FlightDeclarationData;
import com.jphalford.aoc.day6.GroupDeclarationData;
import com.jphalford.aoc.day6.PersonDeclaration;

import java.util.stream.Collectors;

public class AntlrCustomsDeclarationFormListener extends CustomsDeclarationFormBaseListener {

    private FlightDeclarationData.FlightDeclarationDataBuilder flightDeclarationDataBuilder;
    private GroupDeclarationData.GroupDeclarationDataBuilder currentGroupBuilder;

    @Override
    public void enterBatchFile(CustomsDeclarationFormParser.BatchFileContext ctx) {
        flightDeclarationDataBuilder = FlightDeclarationData.builder();
    }

    @Override
    public void enterGroupDeclaration(CustomsDeclarationFormParser.GroupDeclarationContext ctx) {
        currentGroupBuilder = GroupDeclarationData.builder();
    }

    @Override
    public void exitGroupDeclaration(CustomsDeclarationFormParser.GroupDeclarationContext ctx) {
        flightDeclarationDataBuilder.groupDeclarationData(currentGroupBuilder.build());
    }

    @Override
    public void enterPersonDeclaration(CustomsDeclarationFormParser.PersonDeclarationContext ctx) {
        currentGroupBuilder.personDeclaration(
                PersonDeclaration.builder()
                        .yesAnswers(ctx.YES_ANSWER()
                                .stream()
                                .map(t -> t.getText().charAt(0))
                                .collect(Collectors.toSet()))
                        .build());
    }

    public FlightDeclarationData getFlightDeclarationData() {
        return flightDeclarationDataBuilder.build();
    }
}

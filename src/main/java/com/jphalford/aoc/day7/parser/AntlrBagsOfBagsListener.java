package com.jphalford.aoc.day7.parser;

import com.jphalford.aoc.day7.BagsOfBagsData;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AntlrBagsOfBagsListener extends BagsOfBagsBaseListener {
    Map<String, BagsOfBagsData.BagDefinition> bagOfBagsData;

    @Override
    public void enterBatchFile(BagsOfBagsParser.BatchFileContext ctx) {
       bagOfBagsData = new HashMap<>();
    }

    @Override
    public void enterBagDefinition(BagsOfBagsParser.BagDefinitionContext ctx) {
        String bagId = ctx.bagId().getText();
        bagOfBagsData.put(bagId, BagsOfBagsData.BagDefinition.builder()
                .bagId(bagId)
                .bagContents(ctx.bagContent().stream()
                        .map(contentCtx -> BagsOfBagsData.BagContent.builder()
                                .bagId(contentCtx.bagId().getText())
                                .numBags(Integer.parseInt(contentCtx.NUMBER().getText()))
                                .build())
                        .collect(Collectors.toList()))
                .build());
    }

    public BagsOfBagsData getData() {
        return BagsOfBagsData.builder()
                .bagDefinitions(bagOfBagsData)
                .build();
    }
}

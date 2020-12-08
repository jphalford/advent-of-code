package com.jphalford.aoc.day7;

import com.jphalford.aoc.day7.parser.AntlrBagsOfBagsDataParser;
import org.antlr.v4.runtime.CharStream;

public class Day7 {

    private static final String MY_BAG_ID = "shinygold";

    public long solvePart1(CharStream bagOfBagsDataStream) {
        AntlrBagsOfBagsDataParser parser = new AntlrBagsOfBagsDataParser();
        BagsOfBagsData bagsOfBagsData = parser.parse(bagOfBagsDataStream);
        return bagsOfBagsData.stream()
                .map(currentBag -> canContainMyBag(bagsOfBagsData, currentBag.getValue().getBagId()))
                .filter(Boolean::booleanValue)
                .count();
    }

    public long solvePart2(CharStream bagOfBagsDataStream) {
        AntlrBagsOfBagsDataParser parser = new AntlrBagsOfBagsDataParser();
        BagsOfBagsData bagsOfBagsData = parser.parse(bagOfBagsDataStream);
        return countBagsInBag(bagsOfBagsData, MY_BAG_ID);
    }

    private boolean canContainMyBag(BagsOfBagsData bagsOfBagsData, String currentBagId) {
        BagsOfBagsData.BagDefinition bagDefinition = bagsOfBagsData.getBagDefinition(currentBagId);
        return bagDefinition.containsBagId(MY_BAG_ID) ||
                bagDefinition.contentStream()
                        .anyMatch(it -> canContainMyBag(bagsOfBagsData, it.getBagId()));
    }

    private long countBagsInBag(BagsOfBagsData bagsOfBagsData, String currentBagId) {
        BagsOfBagsData.BagDefinition bagDefinition = bagsOfBagsData.getBagDefinition(currentBagId);
        return bagDefinition.contentStream()
                .mapToLong(it -> it.getNumBags() + it.getNumBags() * countBagsInBag(bagsOfBagsData, it.getBagId()))
                .sum();
    }
}

package com.jphalford.aoc.day7;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


@Builder
public class BagsOfBagsData {

    private Map<String, BagDefinition> bagDefinitions;

    public BagDefinition getBagDefinition(String bagId) {
        return bagDefinitions.get(bagId);
    }

    public Stream<Map.Entry<String, BagDefinition>> stream() {
        return bagDefinitions.entrySet().stream();
    }

    @Builder
    public static class BagDefinition {
        @Getter
        String bagId;
        List<BagContent> bagContents;

        public boolean containsBagId(String bagId) {
            return bagContents.stream().anyMatch(bagContent -> bagContent.getBagId().equals(bagId));
        }

        public Stream<BagContent> contentStream() {
            return bagContents.stream();
        }

        public boolean containsBags() {
            return !bagContents.isEmpty();
        }
    }


    @Value
    @Builder
    public static class BagContent {
        int numBags;
        String bagId;
    }
}

package com.jphalford.aoc.day7.parser;

import com.jphalford.aoc.day7.BagsOfBagsData;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AntlrBagsOfBagsDataParserTest {

    private static final String EXAMPLE_BATCH_FILE =
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
                    "faded blue bags contain no other bags.\n";

    @Test
    void testGrammar() {
        AntlrBagsOfBagsDataParser parser = new AntlrBagsOfBagsDataParser();
        BagsOfBagsData bagsOfBagsData = parser.parse(CharStreams.fromString(EXAMPLE_BATCH_FILE));

        assertEquals(BagsOfBagsData.BagDefinition.builder()
                .bagId("vibrantplum")
                .bagContents(asList(BagsOfBagsData.BagContent
                                .builder()
                                .numBags(5)
                                .bagId("fadedblue")
                                .build(),
                        BagsOfBagsData.BagContent.builder()
                                .numBags(6)
                                .bagId("dottedblack")
                                .build()))
                .build(), bagsOfBagsData.getBagDefinition("vibrantplum"));
        assertEquals(BagsOfBagsData.BagDefinition.builder()
                .bagId("fadedblue")
                .bagContents(emptyList())
                .build(), bagsOfBagsData.getBagDefinition("fadedblue"));
    }
}
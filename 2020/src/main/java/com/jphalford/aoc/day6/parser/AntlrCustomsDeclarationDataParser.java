package com.jphalford.aoc.day6.parser;

import com.jphalford.aoc.day6.FlightDeclarationData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrCustomsDeclarationDataParser {

    public FlightDeclarationData parse(CharStream input) {
        CustomsDeclarationFormLexer lexer = new CustomsDeclarationFormLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CustomsDeclarationFormParser parser = new CustomsDeclarationFormParser(tokenStream);

        AntlrCustomsDeclarationFormListener customsDeclarationFormListener = new AntlrCustomsDeclarationFormListener();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(customsDeclarationFormListener, parser.batchFile());

        return customsDeclarationFormListener.getFlightDeclarationData();
    }
}

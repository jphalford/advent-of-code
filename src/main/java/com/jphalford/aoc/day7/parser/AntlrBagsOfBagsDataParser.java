package com.jphalford.aoc.day7.parser;

import com.jphalford.aoc.day7.BagsOfBagsData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrBagsOfBagsDataParser {
    public BagsOfBagsData parse(CharStream input) {
        BagsOfBagsLexer lexer = new BagsOfBagsLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BagsOfBagsParser parser = new BagsOfBagsParser(tokenStream);

        AntlrBagsOfBagsListener listener = new AntlrBagsOfBagsListener();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(listener, parser.batchFile());

        return listener.getData();
    }
}

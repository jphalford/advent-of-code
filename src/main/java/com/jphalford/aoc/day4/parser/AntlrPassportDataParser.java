package com.jphalford.aoc.day4.parser;

import com.jphalford.aoc.day4.PassportData;
import com.jphalford.aoc.day4.PassportLexer;
import com.jphalford.aoc.day4.PassportParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

public class AntlrPassportDataParser {

    public List<PassportData> parse(CharStream input) {
        PassportLexer lexer = new PassportLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PassportParser parser = new PassportParser(tokenStream);

        AntlrPassportListener passportListener = new AntlrPassportListener();
        parser.addParseListener(passportListener);

        parser.batchFile();

        return passportListener.getPassportDataList();
    }
}

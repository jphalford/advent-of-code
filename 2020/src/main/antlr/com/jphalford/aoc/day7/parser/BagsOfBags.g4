grammar BagsOfBags;

@header {
package com.jphalford.aoc.day7.parser;
}

batchFile: bagDefinition+ EOF;

bagDefinition: bagId bagSeperator (bagContent+ | noBags) bagDefinitionTerminator;

bagContent: NUMBER bagId bagCotentsSeperator;

bagSeperator: 'bags' 'contain';
bagCotentsSeperator: ('bag' | 'bags')  COMMA?;
noBags: 'no' 'other' 'bags';
bagId: WORD WORD;
bagDefinitionTerminator: DOT NEWLINE?;

NUMBER: [0-9]+;
COMMA : ',';
DOT : '.';
NEWLINE : ('\r'?)'\n';
WORD: [a-zA-Z]+;
SPACE: [ \t]+ -> skip ;

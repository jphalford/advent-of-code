grammar BagsOfBags;

@header {
package com.jphalford.aoc.day7.parser;
}

batchFile: bagDefinition+ EOF;

bagDefinition: bagId bagSeperator (bagCount+ | noBags) bagDefinitionTerminator;

bagCount: NUMBER bagId bagCountSeperator;

bagSeperator: 'bags' 'contain';
bagCountSeperator: 'bags'  COMMA?;
noBags: 'no' 'other' 'bags';
bagId: WORD WORD;
bagDefinitionTerminator: DOT NEWLINE?;

NUMBER: [0-9]+;
COMMA : ',';
DOT : '.';
NEWLINE : [\r\n];
WORD: [a-zA-Z]+;
SPACE: [ \t]+ -> skip ;

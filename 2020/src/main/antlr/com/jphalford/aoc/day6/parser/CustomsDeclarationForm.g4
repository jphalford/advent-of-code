grammar CustomsDeclarationForm;

@header {
package com.jphalford.aoc.day6.parser;
}

batchFile: groupDeclaration+ EOF;

groupDeclaration: personDeclaration+ GROUP_SEPERATOR? ;

personDeclaration: YES_ANSWER+ PERSON_SEPERATOR?;

PERSON_SEPERATOR: NEWLINE;
GROUP_SEPERATOR: NEWLINE NEWLINE;
YES_ANSWER: ('a'..'z');

fragment NEWLINE: ('\r'?)'\n';
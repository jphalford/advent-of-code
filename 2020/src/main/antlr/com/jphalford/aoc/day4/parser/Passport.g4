grammar Passport;

@header {
package com.jphalford.aoc.day4.parser;
}

batchFile: passport* EOF;

passport: keyValuePair (FIELD_SEPARATOR keyValuePair)* PASSPORT_SEPARATOR ;

keyValuePair: key ':' value;

key : birthYear | issueYear | expirationYear | height | hairColor | eyeColor | passportId | countryId;

birthYear : 'byr';
issueYear : 'iyr';
expirationYear : 'eyr';
height : 'hgt';
hairColor : 'hcl';
eyeColor : 'ecl';
passportId : 'pid';
countryId: 'cid';

value: VALUE;

FIELD_SEPARATOR : ' ' | NEWLINE;
PASSPORT_SEPARATOR : NEWLINE NEWLINE;
VALUE: (LETTER | DIGIT | '#')+;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment NEWLINE: ('\r'?)'\n';

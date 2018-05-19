// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Writer;

@header {package io.antlrgenerated;}

writeDocument		:	document
					|	section
					|	paragraph
					|	sentence
					|	clause
					|	assignments
					;

document			:	DOCUMENT configuration* NEW_LINE (section NEW_LINE)* section
					;

section				:	SECTION configuration* NEW_LINE (paragraph NEW_LINE)* paragraph
					;

paragraph			:	PARAGRAPH configuration* NEW_LINE (sentence NEW_LINE)* sentence
					;

sentence			:	SENTENCE configuration* NEW_LINE (clause NEW_LINE)* clause
					;

clause				:	CLAUSE configuration* NEW_LINE features? (subclause NEW_LINE)* subclause
					|	CLAUSE configuration* NEW_LINE features? assignments
					;

subclause			:	SUBCLAUSE configuration* NEW_LINE features? assignments
					;

configuration		:	documentTitle
					|	sectionTitle
					;

documentTitle		:	'DocumentTitle' '=' documentTitleValue
					;

documentTitleValue	:	STRING
					;

sectionTitle		:	'SectionTitle' '=' sectionTitleValue
					;

sectionTitleValue	:	STRING
					;

features			:	FEATURES NEW_LINE feature+
					;

feature				:	complementiser NEW_LINE
					|	tense NEW_LINE
					|	conjunction NEW_LINE
					;

tense				:	'tense' '=' tenseValue
					;

tenseValue			:	'present'
					|	'past'
					|	'future'
					;

complementiser		:	'complementiser' '=' complementiserValue
					;

complementiserValue	:	STRING
					;

conjunction			:	'conjunction' '=' conjunctionValue
					;

conjunctionValue	:	STRING
					;

assignments			:	(assignment NEW_LINE)* assignment
					;

assignment			:	(option NEW_LINE)* identifier ':' expression
					;

identifier			:	PART_OF_SPEECH
					;
			
expression			:	PLACE_HOLDER_PREFIX STRING
					|	STRING
					;

option				:	decimalPlaces
					;

decimalPlaces		:	DECIMAL_PLACES '=' decimalPlacesValue
					;

decimalPlacesValue	:	NUMERIC
					;

DOCUMENT			:	'Document'
					;

SECTION				:	'Section'
					;

// LIST				:	'List'
//					;

// LIST_ITEM		:	'ListItem'
//					;

PARAGRAPH			:	'Paragraph'
					;

SENTENCE			:	'Sentence'
					;

CLAUSE				:	'Clause'
					;

SUBCLAUSE			:	'Subclause'
					;

FEATURES			:	'Features'
					;
			
PART_OF_SPEECH		:	'Subject'
					|	'Verb'
					|	'Object'
					|	'IndirectObject'
					|	'Complement'
					|	'Modifier'
					|	'Article'
					;

DECIMAL_PLACES		:	'DecimalPlaces'
					;

NUMERIC				:	[0-9]+
					;

STRING				:	[a-zA-Z0-9][a-zA-Z0-9 ]*
					;

NEW_LINE			:	('\r'? '\n')
					;

WHITE_SPACE			:	[ \t]+ -> skip
					;

PLACE_HOLDER_PREFIX	:	'@'
					;

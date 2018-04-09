// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar PhraseCreator;

@header {package writenlg.antlrgenerated;}

writeDocument			:	(concept NEW_LINE)* concept
						;

concept					:	CONCEPT '=' conceptType NEW_LINE phraseSpecifications
						;
						
conceptType				:	CONCEPT_TYPE
						;
					
phraseSpecifications	:	(phraseSpecification NEW_LINE)* phraseSpecification
						;
					
phraseSpecification		:	PHRASE_SPECIFICATION NEW_LINE subject NEW_LINE predicate
						;
						
subject					:	SUBJECT NEW_LINE assignments
						;
						
predicate				:	PREDICATE NEW_LINE assignments
						;
					
assignments				:	(assignment NEW_LINE)* assignment
						;

assignment				:	identifier ':' expression
						;

identifier				:	PART_OF_SPEECH
						;
			
expression				:	PLACE_HOLDER_MARKER STRING PLACE_HOLDER_MARKER
						|	STRING
						;
						
CONCEPT					:	'Concept'
						;
						
CONCEPT_TYPE			:	'MAXIMUM'
						|	'MINIMUM'
						|	'RISING_TREND'
						|	'DESCENDING_TREND'
						|	'MULTIPLE_TRENDS'
						|	'LONGEST_TREND'
						|	'LINES_CROSS'
						|	'SPIKES'
						|	'TURNING_POINTS'
						;
						
PHRASE_SPECIFICATION	:	'PhraseSpecification'
						;
						
SUBJECT					:	'Subject'
						;
						
PREDICATE				:	'Predicate'
						;
					
PART_OF_SPEECH			:	'NOUN'
						|	'PRONOUN'
						|	'ADJECTIVE'
						|	'DETERMINER'
						|	'VERB'
						|	'ADVERB'
						|	'PREPOSITION'
						|	'CONJUNCTION'
						|	'INTERJECTION'
						;
					
NUMERIC					:	[0-9]+
						;
					
STRING					:	[a-zA-Z0-9][a-zA-Z0-9 ]*
						;

NEW_LINE				:	('\r'? '\n')
						;

WHITE_SPACE				:	[ \t]+ -> skip
						;
						
PLACE_HOLDER_MARKER		:	'@@'
						;
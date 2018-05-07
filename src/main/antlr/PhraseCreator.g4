// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar PhraseCreator;

@header {package writenlg.antlrgenerated;}

writeDocument				:	(concept NEW_LINE)* concept
							;
						
concept						:	globalConcept
							|	timeSeriesConcept
							;

globalConcept				:	GLOBAL_CONCEPT '=' globalConceptType NEW_LINE phraseSpecifications
							;
						
globalConceptType			:	GLOBAL_CONCEPT_TYPE
							;
						
timeSeriesConcept			:	TIME_SERIES_CONCEPT '=' timeSeriesConceptType NEW_LINE phraseSpecifications
							;
						
timeSeriesConceptType		:	TIME_SERIES_CONCEPT_TYPE
							;
					
phraseSpecifications		:	(phraseSpecification NEW_LINE)* phraseSpecification
							;
					
phraseSpecification			:	PHRASE_SPECIFICATION NEW_LINE subject NEW_LINE predicate
							;
							
constraint					:	STRING
							;
						
subject						:	SUBJECT NEW_LINE assignments
							;
						
predicate					:	PREDICATE NEW_LINE assignments
							;
					
assignments					:	(assignment NEW_LINE)* assignment
							;

assignment					:	identifier ':' expression
							;

identifier					:	PART_OF_SPEECH
							;
			
expression					:	PLACE_HOLDER_MARKER STRING PLACE_HOLDER_MARKER
							|	STRING
							;
						
GLOBAL_CONCEPT				:	'GlobalConcept'
							;

TIME_SERIES_CONCEPT			:	'TimeSeriesConcept'
							;
							
GLOBAL_CONCEPT_TYPE			:	'LINES_CROSS'
							|	'LINES_DO_NOT_CROSS'
							|	'LINES_CROSS_MULTIPLE_TIMES'
							;
							
TIME_SERIES_CONCEPT_TYPE	:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'SERIES_LEGEND'
							|	'TIME_SLICE'
							;
						
PHRASE_SPECIFICATION		:	'PhraseSpecification'
							;
						
SUBJECT						:	'Subject'
							;
						
PREDICATE					:	'Predicate'
							;
					
PART_OF_SPEECH				:	'NOUN'
							|	'PRONOUN'
							|	'ADJECTIVE'
							|	'DETERMINER'
							|	'VERB'
							|	'ADVERB'
							|	'PREPOSITION'
							|	'CONJUNCTION'
							|	'INTERJECTION'
							|	'COMPLEMENT'
							;
					
STRING						:	[a-zA-Z0-9][a-zA-Z0-9 ]*
							;

NEW_LINE					:	('\r'? '\n')
							;

WHITE_SPACE					:	[ \t]+ -> skip
							;
						
PLACE_HOLDER_MARKER			:	'@@'
							;
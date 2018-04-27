// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar PhraseCreator;

@header {package writenlg.antlrgenerated;}

writeDocument				:	(concept NEW_LINE)* concept
							;
						
concept						:	globalConcept
							|	timeSeriesConcept
							;

globalConcept				:	GLOBAL_CONCEPT '=' globalConceptType weighting? NEW_LINE phraseSpecifications
							;
						
globalConceptType			:	GLOBAL_CONCEPT_TYPE
							;
						
timeSeriesConcept			:	TIME_SERIES_CONCEPT '=' timeSeriesConceptType (NEW_LINE weighting)? NEW_LINE phraseSpecifications
							;
						
timeSeriesConceptType		:	TIME_SERIES_CONCEPT_TYPE
							;
					
phraseSpecifications		:	(phraseSpecification NEW_LINE)* phraseSpecification
							;
					
phraseSpecification			:	PHRASE_SPECIFICATION weighting? NEW_LINE subject NEW_LINE predicate
							;
							
weighting					:	WEIGHTING '=' weightingValue
							;
							
weightingValue				:	WEIGHTING_VALUE
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

WEIGHTING					:	'Weighting'
							;
							
WEIGHTING_VALUE				:	[1-5]
							;
							
GLOBAL_CONCEPT_TYPE			:	'CONSISTENT_DISTANCE_APART'
							|	'LINES_CROSS'
							|	'LINES_MEET'
							;
							
TIME_SERIES_CONCEPT_TYPE	:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'MULTIPLE_TRENDS'
							|	'LONGEST_TREND'
							|	'SPIKES'
							|	'TURNING_POINTS'
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
					
NUMERIC						:	[0-9]+
							;
					
STRING						:	[a-zA-Z0-9][a-zA-Z0-9 ]*
							;

NEW_LINE					:	('\r'? '\n')
							;

WHITE_SPACE					:	[ \t]+ -> skip
							;
						
PLACE_HOLDER_MARKER			:	'@@'
							;
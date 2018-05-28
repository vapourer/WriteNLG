// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar PhraseCreator;

@header {package io.antlrgenerated;}

writeDocument				:	(concept NEW_LINE)* concept
							;
						
concept						:	globalConcept
							|	timeSeriesConcept
							|	aggregationConcept
							;

globalConcept				:	GLOBAL_CONCEPT '=' globalConceptType NEW_LINE phraseSpecifications
							;
						
globalConceptType			:	GLOBAL_CONCEPT_TYPE
							;
						
timeSeriesConcept			:	TIME_SERIES_CONCEPT '=' timeSeriesConceptType NEW_LINE phraseSpecifications
							;
						
timeSeriesConceptType		:	TIME_SERIES_CONCEPT_TYPE
							;
							
aggregationConcept			:	AGGREGATION_CONCEPT '=' aggregationConceptType NEW_LINE phraseSpecifications
							;
							
aggregationConceptType		:	AGGREGATION_CONCEPT_TYPE
							;
					
phraseSpecifications		:	(phraseSpecification NEW_LINE)* phraseSpecification
							;
					
phraseSpecification			:	PHRASE_SPECIFICATION NEW_LINE features? subject NEW_LINE predicate
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
			
expression					:	PLACE_HOLDER_MARKER STRING PLACE_HOLDER_MARKER (' ' STRING)*
							|	STRING
							;
							
features					:	FEATURES NEW_LINE feature+
							;

feature						:	complementiser NEW_LINE
							|	tense NEW_LINE
							|	conjunction NEW_LINE
							|	subjectNumber NEW_LINE
							|	verbNumber NEW_LINE
							|	objectNumber NEW_LINE
							|	complementNumber NEW_LINE
							;

tense						:	'tense' '=' tenseValue
							;

tenseValue					:	'present'
							|	'past'
							|	'future'
							;

complementiser				:	'complementiser' '=' complementiserValue
							;

complementiserValue			:	STRING
							;

conjunction					:	'conjunction' '=' conjunctionValue
							;

conjunctionValue			:	STRING
							;
							
subjectNumber				:	'SubjectNumber' '=' numberValue
							;
							
verbNumber					:	'VerbNumber' '=' numberValue
							;
							
objectNumber				:	'ObjectNumber' '=' numberValue
							;
							
complementNumber			:	'ComplementNumber' '=' numberValue
							;
							
numberValue					:	'singular'
							|	'plural'
							;
						
GLOBAL_CONCEPT				:	'GlobalConcept'
							;

TIME_SERIES_CONCEPT			:	'TimeSeriesConcept'
							;
							
AGGREGATION_CONCEPT			:	'AggregationConcept'
							;
							
GLOBAL_CONCEPT_TYPE			:	'LINES_CROSS'
							|	'LINES_DO_NOT_CROSS'
							|	'LINES_CROSS_MULTIPLE_TIMES'
							|	'LINE_COUNT'
							|	'SERIES_DIFFERENCES_TREND'
							|	'SERIES_DIFFERENCES_AVERAGE'
							;
							
TIME_SERIES_CONCEPT_TYPE	:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'SERIES_LEGEND'
							|	'TIME_SLICE'
							|	'TREND'
							|	'TURNING_POINTS'
							|	'STATIONARY'
							;
							
AGGREGATION_CONCEPT_TYPE	:	'ALL_INTRODUCTORY_INFORMATION_PRESENT'
							|	'BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING'
							|	'BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING'
							|	'BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING'
							|	'BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING'
							|	'IDENTICAL_TIME_SLICES'
							|	'AGGREGATE_MAXIMA'
							|	'AGGREGATE_MINIMA'
							|	'AGGREGATE_MAXIMUM_AND_MINIMUM'
							|	'AGGREGATE_TURNING_POINTS'
							|	'AGGREGATE_STATIONARY'
							|	'AGGREGATE_LINE_BEHAVIOUR'
							;	
						
PHRASE_SPECIFICATION		:	'PhraseSpecification'
							;
						
SUBJECT						:	'Subject'
							;
						
PREDICATE					:	'Predicate'
							;
							
FEATURES					:	'Features'
							;
					
PART_OF_SPEECH				:	'NOUN'
							|	'ADDITIONAL_NOUN'
							|	'PRONOUN'
							|	'ADJECTIVE'
							|	'DETERMINER'
							|	'VERB'
							|	'ADVERB'
							|	'PREPOSITION'
							|	'CONJUNCTION'
							|	'INTERJECTION'
							|	'COMPLEMENT'
							|	'COMPLEMENT2'
							|	'COMPLEMENT3'
							|	'FRONT_MODIFIER'
							|	'PRE_MODIFIER'
							|	'POST_MODIFIER'
							;
					
STRING						:	[a-zA-Z0-9][a-zA-Z0-9 ]*
							;

NEW_LINE					:	('\r'? '\n')
							;

WHITE_SPACE					:	[ \t]+ -> skip
							;
						
PLACE_HOLDER_MARKER			:	'@@'
							;
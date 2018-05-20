// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Aggregation;

@header {package io.antlrgenerated;}

aggregationRules					:	(aggregationConceptGroup NEW_LINE)* aggregationConceptGroup
									;
					
aggregationConceptGroup				:	AGGREGATION_CONCEPT_GROUP '=' aggregationConceptGroupTitle NEW_LINE concepts
									;
					
aggregationConceptGroupTitle		:	AGGREGATION_CONCEPT_GROUP_TITLE
									;
					
// concepts							:	concept (NEW_LINE concept)+
concepts							:	(concept NEW_LINE)* concept
									;
					
concept								:	globalConcept
									|	timeSeriesConcept
									;
						
globalConcept						:	GLOBAL_CONCEPT_NAME '=' GLOBAL_CONCEPT
									;
						
timeSeriesConcept					:	TIME_SERIES_CONCEPT_NAME '=' TIME_SERIES_CONCEPT
									;
						
AGGREGATION_CONCEPT_GROUP			:	'AggregationConceptGroup'
									;

AGGREGATION_CONCEPT_GROUP_TITLE		:	'AllIntroductoryInformationPresent'
									|	'BothSeriesHaveAllSegmentsAscending'
									|	'BothSeriesHaveAllSegmentsDescending'
									|	'BothSeriesHaveMostSegmentsAscending'
									|	'BothSeriesHaveMostSegmentsDescending'
									|	'IdenticalTimeSlices'
									;
									
GLOBAL_CONCEPT_NAME					:	'GlobalConcept'
									;
									
TIME_SERIES_CONCEPT_NAME			:	'TimeSeriesConcept'
									;
						
GLOBAL_CONCEPT						:	'LINES_CROSS'
									|	'LINES_DO_NOT_CROSS'
									|	'LINES_CROSS_MULTIPLE_TIMES'
									|	'LINE_COUNT'
									;
						
TIME_SERIES_CONCEPT					:	'MAXIMUM'
									|	'MINIMUM'
									|	'RISING_TREND'
									|	'DESCENDING_TREND'
									|	'SERIES_LEGEND'
									|	'TIME_SLICE'
									;
						
NEW_LINE							:	('\r'? '\n')
									;
									
WHITE_SPACE							:	[ \t]+ -> skip
									;
						

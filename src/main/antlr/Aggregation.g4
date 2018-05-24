// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Aggregation;

@header {package io.antlrgenerated;}

aggregationRules					:	(aggregationConceptGroup NEW_LINE)* aggregationConceptGroup
									;
					
aggregationConceptGroup				:	AGGREGATION_CONCEPT_GROUP_NAME '=' aggregationConceptGroupTitle NEW_LINE concepts
									;
					
aggregationConceptGroupTitle		:	AGGREGATION_CONCEPT_GROUP
									;
					
concepts							:	(concept NEW_LINE)* concept
									;
									
concept								:	globalConcept
									|	timeSeriesConcept
									;
						
globalConcept						:	GLOBAL_CONCEPT
									;
						
timeSeriesConcept					:	TIME_SERIES_CONCEPT
									;
						
AGGREGATION_CONCEPT_GROUP_NAME		:	'AggregationConceptGroup'
									;
									
AGGREGATION_CONCEPT_GROUP			:	'ALL_INTRODUCTORY_INFORMATION_PRESENT'
									|	'BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING'
									|	'BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING'
									|	'BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING'
									|	'BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING'
									|	'IDENTICAL_TIME_SLICES'
									|	'AGGREGATE_MAXIMA'
									|	'AGGREGATE_MINIMA'
									|	'AGGREGATE_MAXIMUM_AND_MINIMUM'
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
						

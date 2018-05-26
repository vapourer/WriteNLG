// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Constraints;

@header {package io.antlrgenerated;}

constraintConfiguration		:	(concept NEW_LINE)* concept
							;
						
concept						:	globalConcept
							|	timeSeriesConcept
							|	aggregationConcept
							;

globalConcept				:	GLOBAL_CONCEPT '=' globalConceptType NEW_LINE constraints
							;
						
globalConceptType			:	GLOBAL_CONCEPT_TYPE
							;
						
timeSeriesConcept			:	TIME_SERIES_CONCEPT '=' timeSeriesConceptType NEW_LINE constraints
							;
						
timeSeriesConceptType		:	TIME_SERIES_CONCEPT_TYPE
							;
							
aggregationConcept			:	AGGREGATION_CONCEPT '=' aggregationConceptType NEW_LINE constraints
							;
							
aggregationConceptType		:	AGGREGATION_CONCEPT_TYPE
							;
							
constraints					:	(constraint NEW_LINE)* constraint
							;
							
constraint					:	constraintName '=' initialValue ('(' weighting ')')?
							;
							
constraintName				:	CONSTRAINT_NAME
							;
							
initialValue				:	INITIAL_VALUE
							;
							
weighting					:	WEIGHTING
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
							;
							
TIME_SERIES_CONCEPT_TYPE	:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'SERIES_LEGEND'
							|	'TIME_SLICE'
							|	'TREND'
							|	'TURNING_POINTS'
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
							;	
							
CONSTRAINT_NAME				:	'LinesCross'
							|	'LinesCrossMultipleTimes'
							|	'LinesDoNotCross'
							|	'LinesCrossOnce'
							|	'SeriesLegendRequired'
							|	'LineCountRequired'
							|	'SingleObviousMaximum'
							|	'MultipleHighTurningPoints'
							|	'MaximumAtStart'
							|	'MaximumAtEnd'
							|	'SingleObviousMinimum'
							|	'MultipleLowTurningPoints'
							|	'MinimumAtStart'
							|	'MinimumAtEnd'
							|	'AllSegmentsAscending'
							|	'MostSegmentsAscending'
							|	'AllSegmentsDescending'
							|	'MostSegmentsDescending'
							|	'TimeSliceRequired'
							|	'AllIntroductoryInformationPresent'
							|	'BothSeriesHaveAllSegmentsAscending'
							|	'BothSeriesHaveAllSegmentsDescending'
							|	'BothSeriesHaveMostSegmentsAscending'
							|	'BothSeriesHaveMostSegmentsDescending'
							|	'IdenticalTimeSlices'
							|	'MaximumRequired'
							|	'MinimumRequired'
							|	'MaximaAllPresent'
							|	'MinimaAllPresent'
							|	'MaximaAndMinimaAllPresent'
							|	'MultipleTrends'
							|	'AscendingAndDescending'
							;
							
INITIAL_VALUE				:	DIGIT+ '.' DIGIT+
 							|	'.' DIGIT+
							;
							
WEIGHTING					:	[1-5]
 							;

STRING						:	[a-zA-Z0-9][a-zA-Z0-9]*
 							;
							
DIGIT						:	[0-9]
 							;

NEW_LINE					:	('\r'? '\n')
							;

WHITE_SPACE					:	[ \t]+ -> skip
							;
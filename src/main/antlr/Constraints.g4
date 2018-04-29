// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Constraints;

@header {package writenlg.antlrgenerated;}

constraintConfiguration		:	(concept NEW_LINE)* concept
							;
						
concept						:	globalConcept
							|	timeSeriesConcept
							;

globalConcept				:	GLOBAL_CONCEPT '=' globalConceptType NEW_LINE constraints
							;
						
globalConceptType			:	GLOBAL_CONCEPT_TYPE
							;
						
timeSeriesConcept			:	TIME_SERIES_CONCEPT '=' timeSeriesConceptType NEW_LINE constraints
							;
						
timeSeriesConceptType		:	TIME_SERIES_CONCEPT_TYPE
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

GLOBAL_CONCEPT_TYPE			:	'LINES_CROSS'
							|	'LINES_DO_NOT_CROSS'
							;
							
TIME_SERIES_CONCEPT_TYPE	:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'SERIES_LEGEND'
							|	'TIME_SLICE'
							;
							
CONSTRAINT_NAME				:	'LinesCross'
							|	'LinesCrossMultipleTimes'
							|	'LinesDoNotCross'
							|	'SeriesLegendRequired'
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
							;
							
INITIAL_VALUE				:	DIGIT+ '.' DIGIT*
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
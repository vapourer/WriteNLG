// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Aggregation;

@header {package io.antlrgenerated;}

aggregationRules		:	(conceptGroup NEW_LINE)* conceptGroup
						;
					
conceptGroup			:	CONCEPT_GROUP '=' conceptGroupTitle NEW_LINE concepts
						;
					
conceptGroupTitle		:	CONCEPT_GROUP_TITLE
						;
					
concepts				:	concept (NEW_LINE concept)+
						;
					
concept					:	globalConcept
						|	timeSeriesConcept
						;
						
globalConcept			:	GLOBAL_CONCEPT
						;
						
timeSeriesConcept		:	TIME_SERIES_CONCEPT
						;
						
CONCEPT_GROUP			:	'ConceptGroup'
						;

CONCEPT_GROUP_TITLE		:	'AllIntroductoryInformationPresent'
						|	'BothSeriesHaveAllSegmentsAscending'
						|	'BothSeriesHaveAllSegmentsDescending'
						|	'BothSeriesHaveMostSegmentsAscending'
						|	'BothSeriesHaveMostSegmentsDescending'
						;
						
GLOBAL_CONCEPT			:	'LINES_CROSS'
						|	'LINES_DO_NOT_CROSS'
						|	'LINES_CROSS_MULTIPLE_TIMES'
						|	'LINE_COUNT'
						;
						
TIME_SERIES_CONCEPT		:	'MAXIMUM'
						|	'MINIMUM'
						|	'RISING_TREND'
						|	'DESCENDING_TREND'
						|	'SERIES_LEGEND'
						|	'TIME_SLICE'
						;
						
NEW_LINE				:	('\r'? '\n')
						;
						

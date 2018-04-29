// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Constraints;

@header {package writenlg.antlrgenerated;}

constraintConfiguration		:	(concept NEW_LINE)* concept
							;
							
concept						:	CONCEPT_TYPE (NEW_LINE constraint)* NEW_LINE constraint
							;
							
constraint					:	constraintName '=' value
							;
							
constraintName				:	CONSTRAINT_NAME
							;
							
value						:	VALUE
							;
							
// weighting					:	WEIGHTING
//							;
							
CONCEPT_TYPE				:	'MAXIMUM'
							|	'MINIMUM'
							|	'RISING_TREND'
							|	'DESCENDING_TREND'
							|	'MULTIPLE_TRENDS'
							|	'LONGEST_TREND'
							|	'SPIKES'
							|	'TURNING_POINTS'
							|	'SERIES_LEGEND'
							|	'TIME_SLICE'
							|	'CONSISTENT_DISTANCE_APART'
							|	'LINES_CROSS'
							|	'LINES_MEET'
							;
							
CONSTRAINT_NAME				:	'TestConstraint2'
							|	'TestConstraint3'
							|	'TestConstraint4'
							;
							
// VALUE						:	DIGIT
//							;
							
// VALUE						:	DIGIT+ '.' DIGIT*
// 							|	'.' DIGIT+
//							;
							
WEIGHTING					:	[1-5]
							;
							


// STRING						:	[a-zA-Z0-9][a-zA-Z0-9 ]*
// 							;
							
DIGIT						:	[0-9]
							;

NEW_LINE					:	('\r'? '\n')
							;

WHITE_SPACE					:	[ \t]+ -> skip
							;
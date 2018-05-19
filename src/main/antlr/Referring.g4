// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

grammar Referring;

@header {package io.antlrgenerated;}

referringExpression	:	(STRING NEW_LINE)*
					|	STRING
					;

STRING				:	[a-zA-Z0-9][a-zA-Z0-9 ]*
					;

NEW_LINE			:	('\r'? '\n')
					;

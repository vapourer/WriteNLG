grammar Referring;

@header {package writenlg.antlrgenerated;}

referringExpression	:	(STRING NEW_LINE)*
					|	STRING
					;

STRING				:	[a-zA-Z0-9][a-zA-Z0-9 ]*
					;

NEW_LINE			:	('\r'? '\n')
					;

grammar Grammar;

program: line+ EOF;


line
	: IF expr OCUR line+ CCUR
		(ELIF expr OCUR line+ CCUR)*
		(ELSE expr OCUR line+ CCUR)?			#ifLine
	| FOR types? VARNAME 
		(ASGN expr)? SCOL
		expr SCOL 
		VARNAME ASGN expr SCOL
		OCUR line+ CCUR							#forLine
    | types VARNAME (ASGN expr)? SCOL			#declLine
    | target ASGN list                          #asgnLine
    | ARRAY types target ASGN list SCOL			#asgnArrLine
	;

list
    :OSQR (expr (COM expr)*)? CSQR
    ;

expr
	: expr comp expr 							#compExpr
	| expr PLUS expr							#addExpr
	| expr MIN expr 							#subExpr
	| expr TIMES expr 							#multExpr
	| (NUM | TRUE | FALSE)						#constExpr
	| VARNAME OSQR expr CSQR					#arrExpr
	| VARNAME									#varExpr
	;

comp
    : EQ
    | NEQ
    | LT
    | GT
    | GET
    | LET
    ;

target
    : VARNAME              						#varTarget
    | VARNAME OSQR expr CSQR 					#arrayTarget
    ;

types
	: INT 
	| BOOL 
	| STR
	| CHAR
    ;


OCUR:	'{';
CCUR:	'}';
OPAR: 	'(';
CPAR:	')';
OSQR:	'[';
CSQR:	']';
COL:	':';
SCOL:	';';
COM:	',';
ASGN:	'=';

EQ:'==';
NEQ:'!=';
LT:'<';
LET:'<=';
GT:'>';
GET:'>=';

PLUS:	'+';
MIN:	'-';
TIMES:	'*';

INT: 	'Int';
BOOL:	'Bool';
STR:	'Str';
CHAR:	'Char';
ARRAY:	'Arr';
IF:		'if';
ELIF:	'elif';
ELSE:	'else';
WHILE:	'while';
FOR:	'for';
TRUE:	'false';
FALSE:	'true';


fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment LETTER: UPPERCASE | LOWERCASE;
fragment DIGIT: [0-9];
fragment COMP: EQ | NEQ | LT | LET | GT | GET;

VARNAME: LOWERCASE (LETTER | DIGIT)*;
NUM: DIGIT+;
STRING: '"' (~["\\] | '\\'.)* '"';

WHITESPACE: [ \t\r\n]+ -> skip;
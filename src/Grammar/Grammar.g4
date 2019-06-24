grammar Grammar;

program: (function |line)+ EOF;

function: FUN (types)? FUNNAME VARNAME* OCUR line+ (RETURN expr)? CCUR;


functioncall: FUNNAME expr* SCOL;

line
	: IF expr OCUR line* CCUR
		(ELIF expr OCUR line* CCUR)*
		(ELSE OCUR line* CCUR)?			#ifLine
	| FOR INT? VARNAME
		(ASGN expr)? SCOL
		expr SCOL 
		VARNAME ASGN expr SCOL
		OCUR line* CCUR							#forLine
	| PARALLEL OCUR line* CCUR                  #parallelLine
    | SEQUENTIAL OCUR line* CCUR                #sequentialLine
    | types VARNAME (( ASGN expr) |functioncall)? SCOL	        #declLine
    | target ASGN (expr|functioncall) SCOL      #asgnLine
    | (LOCK | UNLOCK) VARNAME SCOL              #lockLine
    | functioncall                              #funcallLine
//    | RETURN expr SCOL                          #returnLine
    ;

expr
    : OPAR expr CPAR                            #parensExpr
    // | (NOT | MIN) expr                       #notExpr
	| expr comp expr 							#compExpr
	| expr TIMES expr 							#multExpr
	| expr (PLUS|MIN) expr						#addorsubExpr
	| (NUM | TRUE | FALSE)						#constExpr
	| VARNAME OSQR expr CSQR					#arrExpr
	| VARNAME									#varExpr
	| OSQR (expr (COM expr)*)? CSQR             #listExpr
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
	: INT                                       #int
	| BOOL                                      #bool
	| CHAR                                      #char
	| STR                                       #str
	| ARRAY types                               #array
    ;



FUN: 'Fun';
RETURN: 'return';
LOCK: 'lock';
UNLOCK: 'unlock';
PARALLEL: 'parallel';
SEQUENTIAL: 'sequential';

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

NOT:'!';

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

FUNNAME: UPPERCASE (LETTER | DIGIT)*;
VARNAME: LOWERCASE (LETTER | DIGIT)*;
NUM: DIGIT+;
STRING: '"' (~["\\] | '\\'.)* '"';

WHITESPACE: [ \t\r\n]+ -> skip;
grammar Grammar;

program: (function|line)+ EOF;

function: FUN (types)? FUNNAME (types VARNAME)* OCUR line+ (RETURN expr)? CCUR;

sequential: SEQUENTIAL OCUR line+ CCUR; // must have at least one line otherwise useless
line
	: IF expr OCUR line* CCUR
		(ELIF expr OCUR line* CCUR)*
		(ELSE OCUR line* CCUR)?							#ifLine
	//for is not supported at this moment
	| FOR (VARNAME | INT VARNAME ASGN expr) SCOL
		expr SCOL
		VARNAME ASGN expr SCOL
		OCUR line* CCUR									#forLine
	| WHILE expr OCUR line* CCUR						#whileLine
	| PARALLEL OCUR sequential+ CCUR                  	#parallelLine
    | types VARNAME
        (ASGN expr | ASGN functioncall)? SCOL	        #declLine
    //function calls not supported yet
    | target ASGN (expr | functioncall) SCOL      		#asgnLine
    | (LOCK | UNLOCK) VARNAME SCOL              		#lockLine
    //function calls not supported yet
    | functioncall SCOL                             	#funcallLine
    ;

expr
    : OPAR expr CPAR                            		#parensExpr
    // | (NOT | MIN) expr                      			#notExpr
	| expr comp expr 									#compExpr
	| expr TIMES expr 									#multExpr
	| expr (PLUS|MIN) expr								#addorsubExpr
	| (NUM | TRUE | FALSE | STRING)						#constExpr
	| VARNAME OSQR expr CSQR							#arrExpr
	| VARNAME											#varExpr
	//arays are not fully supported at this moment
	| OSQR expr (COM expr)* CSQR             		    #listExpr
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
    : VARNAME              								#varTarget
    //arrays are not fully supported at this moment
    | VARNAME OSQR expr CSQR 							#arrayTarget
    ;

functioncall: FUNNAME expr*;

types
	: INT                                       		#int
	| BOOL                                      		#bool
	//| CHAR                                      		#char
	| STR                                       		#str
	//arrays are not fully supported at this moment
	| ARRAY types                               		#array
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
TRUE:	'true';
FALSE:	'false';


fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment LETTER: UPPERCASE | LOWERCASE;
fragment DIGIT: [0-9];
fragment COMP: EQ | NEQ | LT | LET | GT | GET;

FUNNAME: UPPERCASE (LETTER | DIGIT)*;
VARNAME: LOWERCASE (LETTER | DIGIT)*;
NUM: DIGIT+;

//no whitespace allowed in strings!
STRING: '"' [\u0000\u0021\u0023-\uFFFE]* '"';
// CHARACTER: '\'' . '\'';


WHITESPACE: [ \t\r\n]+ -> skip;
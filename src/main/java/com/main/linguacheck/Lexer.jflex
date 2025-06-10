%%

%class Lexer
%unicode
%public
%type String
%line

//Definicion de tokens
WHITESPACE = [ \t\n\r]+
NUMBER = [0-9]*
IDENTIFIER = [a-zA-Z][a-zA-Z]*

%%

{WHITESPACE}    {/*Ignoramos los espacios en blanco */}
{NUMBER}        {return "NUMBER " + yytext()+"\n"; }
{IDENTIFIER}    {return "IDENTIFIER "+yytext()+"\n";}
.               {return "ERROR: "+yytext();} //Capturamos la palabra mal escrita
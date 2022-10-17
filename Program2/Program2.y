%{
	#include<stdio.h>
	#include<stdlib.h>
	int yylex();
	int yyerror();
%}

%token A B

%%

input:s'\n' 	{
			printf("Successful Grammar\n");
			exit(0);
		}

s: A s1 B| B

s1: ; | A s1;

%%

int yyerror()
{
	printf("Unsuccessful Grammar\n"); 
	exit(0);
}

int main()
{
	printf("Enter A String\n"); 
	yyparse();
}

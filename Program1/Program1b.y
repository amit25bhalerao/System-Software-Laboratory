%{
	#include<stdio.h>
	#include<stdlib.h>
	int yyerror();
	int yylex();
%}

%token num
%left '+' '-'
%left '*' '/'

%%

input:exp 		{
				printf("%d\n",$$);
				exit(0);
			}

exp:
	exp'+'exp 	{
				$$=$1+$3;
			}

	|exp'-'exp	{	
				$$=$1-$3;
			}

	|exp'*'exp	{	
				$$=$1*$3;
			}

	|exp'/'exp 	{ 	
				if($3==0)
				{
					printf("Divide By Zero Error\n");
					exit(0);
				}
				else
				{	
					$$=$1/$3;
				}
			}
	
	|'('exp')'	{
				$$=$2;
			}
	
	|num		{
				$$=$1;
			};

%%

int yyerror()
{
	printf("Error Present In The Given Expression!\n");
	exit(0);
}

int main()
{
	printf("Enter An Expression: \n");
	yyparse();
}



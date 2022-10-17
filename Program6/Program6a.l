%{
	#include<stdio.h>
	int sl=0;
	int ml=0;
	int yywrap();
%}

%%

"/*"[a-zA-Z0-9' '\t\n]+"*/" 		ml++;

"//".* 				sl++;

%%

int yywrap()
{
	return(1);
}

int main()
{
	yyin=fopen("f1.c","r");
	yyout=fopen("f2.c","w");
	yylex();
	fclose(yyin);
	fclose(yyout);
	printf("Number Of Single Line Comments: %d\n",sl);
	printf("Number Of Multi Line Comments: %d\n",ml);
	return 0;
}

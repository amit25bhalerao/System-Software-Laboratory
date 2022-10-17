%{
        #include<stdio.h>
        int m=0,b=0,n=0;
%}

%%

[a-z|A-Z] 	{++m;}

[0-9]+ 	{++m;}

[(] 		{++b;}

[)] 		{--b;}

[\+|\-|\*|\/] 	{++n;}  

.|\n 		{return 0;}

%%

void main(int argc, char*argv[])
{
        yyin=fopen(argv[1],"r");
        yylex();
        if(n==0 || b!=0)
        {
                printf("Invalid Expression\n");
        }
        else if(m=n+1)
        {
                printf("Valid Expression\n");
                printf("The Number Of Identifiers: %d\n",n+1);
                printf("The Number of Operators: %d\n",n);
        }
        int yywrap()
        {
                return -1;
        }
}

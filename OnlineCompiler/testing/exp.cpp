#include<iostream>
#include<stdio.h>
#include<string.h>

bool isDivisible(char *string,int length)
{
int number=0;
int x=strlen(string)-2;
while(x<length)
{
number=number*10+(string[x]-48);
x++;
}

return number%4==0;
}


void swap(char *s1,char *s2)
{
char temp;
temp=*s1;
*s1=*s2;
*s2=temp;
}

bool permute(char *string,int l,int r,bool value)
{
if(l==r)
{
if(isDivisible(string,r))
{
return true;
}
}
for(int i=l;i<=r;i++)
{
swap(string+l,string+i);
value=permute(string,l+1,r,value);
if(value==true)return true;
swap(string+i,string+l);

}

return value;
}

int main()
{
int testcase,number;
scanf("%d",&testcase);
char numberInString[10200];

while(testcase--)
{
scanf("%s",numberInString);
if(isDivisible(numberInString,strlen(numberInString)))
{
printf("1\n");
}
else
{
bool value=permute(numberInString,0,strlen(numberInString)-1,false);
if(value)
{
printf("1\n");
}
else
{
printf("0\n");

}
}
}

return 0;
}
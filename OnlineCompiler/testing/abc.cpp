#include<iostream>
#include<stdio.h>

int main()
{
int testcase,size,x,y,z;
scanf("%d",&testcase);

while(testcase--)
{
scanf("%d",&size);
int array[size];
x=0;
while(x<size)
{
scanf("%d",&array[x++]);
}


bool hasZero=false;
int flag=0;
x=0;
while(x<size)
{
y=0;
while(y<size)
{
z=0;
while(z<size)
{
if(z!=x&&x!=y)
{
if(array[x]+array[y]+array[z]==0)
{
hasZero=true;
flag=1;
break;
}
}
z++;
}
if(flag==1)
{
break;
}
y++;
}
if(flag==1)
{
break;
}
x++;
}
printf("%d\n",hasZero);


}






return 0;
}

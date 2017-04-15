function selectLanguageFunction(pointer)
{
var textArea=document.getElementById('codeTextarea');
if(pointer.value=='Java')
{
document.getElementById('codeTextarea').innerHTML='class psp\n'+
'{\n'+
'public static void main(String a[])\n'+
'{\n'+
'//add your code here\n'+
'}\n'+
'}';

}

if(pointer.value=='C')
{
document.getElementById('codeTextarea').innerHTML='#include<stdio.h>\n'+
'int main()\n'+
'{\n'+
'//add your code here\n'+
'return 0;\n'+
'}\n';

}

if(pointer.value=='C++')
{
document.getElementById('codeTextarea').innerHTML='#include<iostream>\n'+
'int main()\n'+
'{\n'+
'//add your code here\n'+
'return 0;\n'+
'}\n';


}
if(pointer.value=='Python')
{
document.getElementById('codeTextarea').innerHTML='';
}


}

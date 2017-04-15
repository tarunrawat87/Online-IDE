function validateForm(pointer)
{
var x=0;
var check=0;
while(x<pointer.languageRadioButton.length)
{
if(pointer.languageRadioButton[x++].checked==true)
{
return true;
}
}
if(x==pointer.languageRadioButton.length)
{
alert('select a chioce');
}
return false;
}

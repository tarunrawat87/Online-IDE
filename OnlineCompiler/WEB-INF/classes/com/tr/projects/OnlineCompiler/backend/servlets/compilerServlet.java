package com.tr.projects.OnlineCompiler.backend.servlets;

import com.tr.projects.OnlineCompiler.backend.*;
import com.tr.projects.OnlineCompiler.backend.exceptions.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class compilerServlet extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String code=request.getParameter("code");
String type=request.getParameter("codetype");
String output="";
String input=request.getParameter("stdin");
System.out.println(type);

System.out.println("Hello");


File file=new File("c:\\tomcat7\\webapps\\OnlineCompiler\\compilerFiles\\progamInput.txt");
try
{
if(file.exists())file.delete();
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(input!=null)
randomAccessFile.writeBytes(input);
randomAccessFile.close();
}catch(IOException e)
{
System.out.println(e);
}



CodeCompiler compiler=new CodeCompiler();
try{
compiler.getCompiler(type,code,output,input);
response.setContentType("text/html");

PrintWriter pw=response.getWriter();

pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("   <head>");
pw.println("<script src='selectLanguage.js'>");
pw.println("</script>");
pw.println("   <head>");

pw.println("   <style type='text/css'>");
pw.println("   #codeTextarea{");
pw.println("height:300px;");
pw.println("width:670px;      ");
pw.println("max-height:300px;");
pw.println("}");
pw.println("   .textAreaWithLines{");
pw.println("     position: absolute;");
pw.println("top:50px;");
pw.println("left:0px;");
pw.println("");
pw.println("  font-family:courier;      ");
pw.println("      border:0px solid white;");
pw.println("      ");
pw.println("   }");
pw.println("   .textAreaWithLines textarea,.textAreaWithLines div{");
pw.println("      border:0px;");
pw.println("      line-height:130%;");
pw.println("      font-size:13px;");
pw.println("   }");
pw.println("   .lineObj{");
pw.println("      color:#333;");
pw.println("   }");
pw.println("");
pw.println("#upper");
pw.println("{");
pw.println("position: absolute;");
pw.println("");
pw.println("    width:1370px;");
pw.println("    border: 1px solid grey;");
pw.println("    padding: 0px;");
pw.println("    margin: 0px;");
pw.println("   background-color:grey;");
pw.println("   color:white;");
pw.println("border-radius: 0px");
pw.println("height:10px;");
pw.println("}");
pw.println("");
pw.println("");
pw.println(".button1 {");
pw.println("   ");
pw.println("background-color:#333;/* Green */");
pw.println("    border: none;");
pw.println("    color: white;");
pw.println("    padding: 15px 32px;");
pw.println("    text-align: center;");
pw.println("    text-decoration: none;");
pw.println("    display: inline-block;");
pw.println("    font-size: 16px;");
pw.println("}");
pw.println("");
pw.println("#editorArea");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:60px;");
pw.println("left:220px;");
pw.println("width: 730px;");
pw.println("height:1000px;");
pw.println("border: 4px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 5px;");
pw.println("");
pw.println("border-radius:10px;");
pw.println("box-shadow: 5px 5px   5px gray;");
pw.println("}");
pw.println("");
pw.println("#stdin{");
pw.println("position: absolute;");
pw.println("top:390px;");
pw.println("left:10px;");
pw.println("width:700px;");
pw.println("height:100px;");
pw.println("}");
pw.println("");
pw.println("#selectOption{");
pw.println("position: absolute;");
pw.println("top:510px;");
pw.println("left:10px;");
pw.println("width:150px;");
pw.println("height:20px;");
pw.println("}");
pw.println(" .button1:active {");
pw.println("  background-color: #333;");
pw.println("  box-shadow: 0 5px #333;");
pw.println("  transform: translateY(4px);");
pw.println("}");
pw.println("");
pw.println("#statusbar");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:0px;");
pw.println("left:0px;");
pw.println("width: 680px;");
pw.println("height:40px;");
pw.println("border: 1px solid grey;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#compileInfo");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:560px;");
pw.println("left:20px;");
pw.println("width: 680px;");
pw.println("height:430px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#inputMessage");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:270px;");
pw.println("left:20px;");
pw.println("width: 640px;");
pw.println("height:150px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("background-color:#FFDFC4;");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#compilerMessage");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:75px;");
pw.println("left:20px;");
pw.println("width: 640px;");
pw.println("height:150px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("background-color:#FFDFC4;");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("");
pw.println("   </style>");
pw.println("   ");
pw.println("   <script type='text/javascript'   src='textareaScript.js'>");
pw.println("   ");
pw.println("   </script>");
pw.println("   ");
pw.println("   </head>   ");
pw.println("   <body>");
pw.println("<div id='upper'>");
pw.println("<a href='' style='color:white;font-size:222%;text-decoration:none' > CodePad</a>");
pw.println("</div>");
pw.println("");
pw.println("<div id='editorArea'>");
pw.println("<!--<h3 style='position:absolute;left:200px;top:01px;font-size:150%;color:#333;text-shadow: 2.5px 1.5px  1px gray;'>Code Compile & Run</h3>-->");
pw.println("<form action='/OnlineCompiler/compiler'>");
pw.println("<textarea id='codeTextarea' name='code'>");
pw.println(code);
pw.println("</textarea >");
pw.println("<p style='position:absolute;left:25px;top:350px'>enter your input<p>");
pw.println("<textarea id='stdin' name='stdin'>");
pw.println(input);
pw.println("</textarea>");
pw.println("<input type='submit' class='button1' value='Compile' style='position:absolute;left:580px;top:500px'>");
pw.println("<select id='selectOption' onchange='javascript123()' name='codetype'>");
pw.println("<option value='C' name='C'>C</option>");
pw.println("<option value='C++' name='C++'>C++</option>");
pw.println("<option value='Java' name='Java'>Java</option>");
pw.println("<option value='Python' name='Python'>Python</option>");
pw.println("");
pw.println("</select>");
pw.println("</form>");
pw.println("   <script type='text/javascript'>");
pw.println("   createTextAreaWithLines('codeTextarea');");
pw.println("   </script>");
pw.println("<div id='compileInfo'> ");
pw.println("<div id='statusbar'>");
pw.println("</div>");
pw.println("<p style='font-size:120%;font-family:Arial,Helvetica,sans-serif;position:absolute;left:22px;top:34px;'>Compilation Info</p>");
pw.println("<textarea id='compilerMessage'>");
pw.println("</textarea>");
pw.println("<p style='font-size:120%;font-family:Arial,Helvetica,sans-serif;position:absolute;left:22px;top:224px;'>Output Info</p>");
pw.println("");
pw.println("<textarea id='inputMessage'>");
System.out.println("servlet input :"+output);
pw.println(compiler.getOutput());
pw.println("</textarea>");
pw.println("");
pw.println("</div>");
pw.println("</div>  ");
pw.println("</div>");
pw.println("");
pw.println("</body>");
pw.println("</html>");


}catch(backendException e)
{
response.setContentType("text/html");
try
{
PrintWriter pw=response.getWriter();

pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("   <head>");
pw.println("   <style type='text/css'>");
pw.println("   #codeTextarea{");
pw.println("height:300px;");
pw.println("width:670px;      ");
pw.println("max-height:300px;");
pw.println("}");
pw.println("   .textAreaWithLines{");
pw.println("     position: absolute;");
pw.println("top:50px;");
pw.println("left:0px;");
pw.println("");
pw.println("  font-family:courier;      ");
pw.println("      border:0px solid white;");
pw.println("      ");
pw.println("   }");
pw.println("   .textAreaWithLines textarea,.textAreaWithLines div{");
pw.println("      border:0px;");
pw.println("      line-height:130%;");
pw.println("      font-size:13px;");
pw.println("   }");
pw.println("   .lineObj{");
pw.println("      color:#333;");
pw.println("   }");
pw.println("");
pw.println("#upper");
pw.println("{");
pw.println("position: absolute;");
pw.println("");
pw.println("    width:1370px;");
pw.println("    border: 1px solid grey;");
pw.println("    padding: 0px;");
pw.println("    margin: 0px;");
pw.println("   background-color:grey;");
pw.println("   color:white;");
pw.println("border-radius: 0px");
pw.println("height:10px;");
pw.println("}");
pw.println("");
pw.println("");
pw.println(".button1 {");
pw.println("   ");
pw.println("background-color:#333;/* Green */");
pw.println("    border: none;");
pw.println("    color: white;");
pw.println("    padding: 15px 32px;");
pw.println("    text-align: center;");
pw.println("    text-decoration: none;");
pw.println("    display: inline-block;");
pw.println("    font-size: 16px;");
pw.println("}");
pw.println("");
pw.println("#editorArea");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:60px;");
pw.println("left:220px;");
pw.println("width: 730px;");
pw.println("height:1000px;");
pw.println("border: 4px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 5px;");
pw.println("");
pw.println("border-radius:10px;");
pw.println("box-shadow: 5px 5px   5px gray;");
pw.println("}");
pw.println("");
pw.println("#stdin{");
pw.println("position: absolute;");
pw.println("top:390px;");
pw.println("left:10px;");
pw.println("width:700px;");
pw.println("height:100px;");
pw.println("}");
pw.println("");
pw.println("#selectOption{");
pw.println("position: absolute;");
pw.println("top:510px;");
pw.println("left:10px;");
pw.println("width:150px;");
pw.println("height:20px;");
pw.println("}");
pw.println(" .button1:active {");
pw.println("  background-color: #333;");
pw.println("  box-shadow: 0 5px #333;");
pw.println("  transform: translateY(4px);");
pw.println("}");
pw.println("");
pw.println("#statusbar");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:0px;");
pw.println("left:0px;");
pw.println("width: 680px;");
pw.println("height:40px;");
pw.println("border: 1px solid grey;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#compileInfo");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:560px;");
pw.println("left:20px;");
pw.println("width: 680px;");
pw.println("height:430px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#inputMessage");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:270px;");
pw.println("left:20px;");
pw.println("width: 640px;");
pw.println("height:150px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("background-color:#FFDFC4;");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("#compilerMessage");
pw.println("{");
pw.println("position: absolute;");
pw.println("top:75px;");
pw.println("left:20px;");
pw.println("width: 640px;");
pw.println("height:150px;");
pw.println("border: 1px solid grey;");
pw.println("padding: 0px;");
pw.println("margin: 0px;");
pw.println("background-color:#FFDFC4;");
pw.println("border-radius:0px;");
pw.println("");
pw.println("}");
pw.println("");
pw.println("");
pw.println("   </style>");
pw.println("   ");
pw.println("   <script type='text/javascript'   src='textareaScript.js'>");
pw.println("   ");
pw.println("   </script>");
pw.println("   ");
pw.println("   </head>   ");
pw.println("   <body>");
pw.println("<div id='upper'>");
pw.println("<a href='' style='color:white;font-size:222%;text-decoration:none' > CodePad</a>");
pw.println("</div>");
pw.println("");
pw.println("<div id='editorArea'>");
pw.println("<!--<h3 style='position:absolute;left:200px;top:01px;font-size:150%;color:#333;text-shadow: 2.5px 1.5px  1px gray;'>Code Compile & Run</h3>-->");
pw.println("<form action='/OnlineCompiler/compiler'>");
pw.println("<textarea id='codeTextarea' name='code'>");
pw.println(code);
pw.println("</textarea >");
pw.println("<p style='position:absolute;left:25px;top:350px'>enter your input<p>");
pw.println("<textarea id='stdin' name='stdin' >");
pw.println("</textarea>");
pw.println("<input type='submit' class='button1' value='Compile' style='position:absolute;left:580px;top:500px'>");
pw.println("<select id='selectOption' onchange='javascript123()' name='codetype'>");
pw.println("<option value='C' name='C'>C</option>");
pw.println("<option value='C++' name='C++'>C++</option>");
pw.println("<option value='Java' name='Java'>Java</option>");
pw.println("<option value='Python' name='Python'>Python</option>");
pw.println("");
pw.println("</select>");
pw.println("</form>");
pw.println("   <script type='text/javascript'>");
pw.println("   createTextAreaWithLines('codeTextarea');");
pw.println("   </script>");
pw.println("<div id='compileInfo'> ");
pw.println("<div id='statusbar'>");
pw.println("</div>");
pw.println("<p style='font-size:120%;font-family:Arial,Helvetica,sans-serif;position:absolute;left:22px;top:34px;'>Compilation Info</p>");
pw.println("<textarea id='compilerMessage'>");
pw.println(e.getMessage());//Printing error message on document
pw.println("</textarea>");
pw.println("<p style='font-size:120%;font-family:Arial,Helvetica,sans-serif;position:absolute;left:22px;top:224px;'>Output Info</p>");
pw.println("");
pw.println("<textarea id='inputMessage'>");
pw.println("</textarea>");
pw.println("");
pw.println("</div>");
pw.println("</div>  ");
pw.println("</div>");
pw.println("");
pw.println("</body>");
pw.println("</html>");

}catch(Exception ee)
{
System.out.println(ee);
}

}
catch(Exception ex)
{
System.out.println(ex);
}
releaseResources();

}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

private void releaseResources()
{
try
{
}catch(Exception exception)
{
System.out.println(exception);
}
}

}
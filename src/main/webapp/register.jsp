<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Register</h2>
<form action="register" method="POST">
<p>Username:<input type="text" name="username"/></p>
<p>Password:<input type="text" name="password"/></p>
<p>confirm Password:<input type="text" name="cpassword"/></p>

<%
     if(request.getAttribute("error") != null){
          out.print("<p>Enter valid credential to register</p>");
        }
     %>
<input class="" type="submit" value="register"/>
</body>
</html>

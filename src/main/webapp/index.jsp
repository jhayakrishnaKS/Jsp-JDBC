<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

<h2 class="container">Login</h2>
<form action="Login" method="POST">
<p class="container">Username:<input type="text" name="username"/></p>
<p class="container">Password:<input type="text" name="password"/></p>
<%
     if(request.getAttribute("error") != null){
          out.print("<p>Invalid Credential</p>");
        }
     %>
<div class="container"><input type="submit" value="Login"/></div>

</form>
<form action="register" method="POST"><div class="container"><input type="submit" value="register"/></div></form>
</body>
</html>

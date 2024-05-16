<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	
	<h2> index page </h2>
	<% if (session.getAttribute("id") == null) {%>
	<a href="../member/signupForm.jsp">Sign up</a><br>
	<a href="../member/loginForm.jsp">login</a><br>
	<% } else { %>
	<a href="../member/logout.jsp">logout</a>
	<% } %>
	
</body>
</html>
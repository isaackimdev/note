<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Form Page</title>
<script type="text/javascript" src="./js/member.js"></script>
</head>
<body>
	<h2>login Form Page</h2>
	<form name="loginForm" action="./login.jsp" method="post">
		<input type="text" name="id" placeholder="id">
		<br>
		<input type="password" name="pwd" placeholder="pwd">
		<br>
		<input type="button" value="login" onclick="login()">
	</form>
</body>
</html>
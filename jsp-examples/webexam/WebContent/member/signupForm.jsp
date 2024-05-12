<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up form</title>
<script type="text/javascript" src="./js/member.js"></script>
</head>
<body>
	<h2>sign up form page</h2>
	
	<form action="signup.jsp" name="signupForm" method="post">
		<input type="text" name="name" placeholder="이름">
		<br>
		<input type="text" name="id" placeholder="id">
		<br>
		<input type="password" name="pwd" placeholder="password">
		<br>
		<input type="password" name="pwd2" placeholder="password">
		<br>
		<input type="radio" name="gender" value="m" checked> 남
		<input type="radio" name="gender" value="f"> 여
		<br>
		<input type="text" name="email1">@
		<select name="email2">
			<option value="naver.com">naver.com</option>
			<option value="hanmail.net">hanmail.net</option>
			<option value="gmail.com">gmail.com</option>
			<option value="nate.com">nate.com</option>
		</select>
		<br>
		<input type="button" value="sign up" onclick="signUp()">
		<input type="reset" value="reset">
	</form>
</body>
</html>
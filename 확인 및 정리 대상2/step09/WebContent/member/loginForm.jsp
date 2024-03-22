<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="login.jsp" name="loginForm" method="post">
<table border="1">
	<tr>
		<td width="70" align="center">아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입">
		</td>
	</tr>
</table>
</form>


</body>
</html>
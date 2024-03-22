<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(클라이언트)</title>
<script type="text/javascript" src="../script/memberScript.js?v=1">
</script>
</head>
<body>
	<form action="login.jsp" name="loginForm" method="post">
		<table border="1">
			<tr>
				<td align="center" width="70">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<input type="button" value="로그인" onclick="checkLogin()">
					<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'">
				</td>
			</tr>
			
		</table>
	</form>
<a href="../main/index.jsp">메인 화면</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<script type="text/javascript" src="../script/memberScript.js">
</script>
</head>
<body>
<form action="../member/login.jsp" name="loginForm" method="post">
	<table>
		<tr>
			<td><input type="text" size="15" name="id" placeholder="아이디"></td>
			<td rowspan="2">
				<input type=button
				style="width:37pt;height:37pt;background: skyblue;"
				 value="Login" onclick="checkLogin()">
				</td>
		</tr>
		<tr>
			<td><input type="password" size="16" name="pwd" placeholder="비밀번호"></td>
		</tr>
	</table>
</form>
</body>
</html>
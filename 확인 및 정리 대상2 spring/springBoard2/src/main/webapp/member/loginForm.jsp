<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="../script/memberScript.js">
</script>
</head>
<body>
<form action="../member/login.do" name="loginForm" method="post">
	<table border="1">
		<tr>
			<td width="70" align="center">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td width="70" align="center">비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="로그인" onclick="javascript:checkLogin()">
				<input type="button" value="회원가입" onclick="javascript:location.href='../member/writeForm.do'">
			</td>
		</tr>
	</table>
</form>
<!--  <a href="../main/index.jsp">메인 화면</a> -->
</body>
</html>









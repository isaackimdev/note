<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../script/memberScript.js?v=1">
</script>
</head>
<body>
<form action="write.do" name="writeForm" method="post">
	<table border="1">
		<tr>
			<td width="70" align="center">이름</td>
			<td><input type="text" name="name" placeholder="이름 입력"></td>
		</tr>
		<tr>
			<td width="70" align="center">아이디</td>
			<td>
				<input type="text" name="id">
				<input type="button" value="중복체크" onclick="checkId()">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td width="70" align="center">재확인</td>
			<td><input type="password" name="repwd"></td>
		</tr>
		<tr>
			<td width="70" align="center">성별</td>
			<td>
				<input type="radio" name="gender" value="0" checked>남
				<input type="radio" name="gender" value="1">여
			</td>
		</tr>
		<tr>
			<td width="70" align="center">이메일</td>
			<td>
				<input type="text" name="email1">@
				<select name="email2" style="width: 100px;">
					<option value="naver.com">naver.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="hanmail.com">hanmail.com</option>
					<option value="nate.com">nate.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width="70" align="center">핸드폰</td>
			<td>
				<select name="tel1" style="width: 70px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
				</select>-
				<input type="text" name="tel2" size="10">-
				<input type="text" name="tel3" size="10">
			</td>
		</tr>
		<tr>
			<td width="70" align="center">주소</td>
			<td>
				<input type="text" name="addr">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="checkWrite()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>	
</form>
<a href="../main/index.do">메인 화면</a>
</body>
</html>











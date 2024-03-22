<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../script/memberScript.js"
></script>
</head>
<body>
	<form action="../member/write.jsp" name="writeForm" method="post">
		<table>

			<tr>
				<td width="128" align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id">
					<input type="button" value="중복체크" onclick="checkId()">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">비밀번호</td>
				<td>
					<input type="password" name="pwd" size="30">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">비밀번호 재확인</td>
				<td>
					<input type="password" name="repwd" size="30">
				</td>
			</tr>
			<tr>
				<td width="70" align="center">이름</td>
				<td width=400px>
					<input type="text" name="name" placeholder="이름 입력">
				</td>
			</tr>	
			<tr>
				<td width="70" align="center">생년월일</td>
				<td width=400px>
					<input type="text" name="birth" placeholder="ex)19911215">
				</td>
			</tr>	
			<tr>
				<td width="70" align="center">성별</td>
				<td>
					<input type="radio" name="gender" value="m" checked> 남
					<input type="radio" name="gender" value="f"> 여
				</td>
			</tr>
			<tr>
				<td width="70" align="center">이메일</td>
				<td>
					<input type="text" name="email1">@
					<select name="email2" style="width: 100px;">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">hanmail.net</option>
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
					<input type="text" name="addr" size="40">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="회원가입" onclick="checkWrite()">
					<input type="reset"	value="다시 작성">		
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
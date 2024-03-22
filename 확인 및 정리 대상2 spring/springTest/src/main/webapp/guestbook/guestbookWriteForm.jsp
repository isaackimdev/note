<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기 화면</title>
<script type="text/javascript" src="../script/guestbookScript.js"></script>
</head>
<body>

<form action="guestbookWrite" name="guestbookForm" id="guestbookForm" method="post">
	<table border="1">
		<tr>
			<td class="left">
				<label>방문자</label>
			</td>
			<td><input type="text" id="guest_writer" name="guest_writer"></td>
		</tr>
		<tr>
			<td>이메일주소</td>
			<td><input type="email" id="guest_email" name="guest_email"></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><input type="text" id="guest_subject" name="guest_subject"></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><textarea rows="10" cols="35" id="guest_content" name="guest_content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="작성하기" onclick="guestbookCheck();">
				<input type="reset" value="다시쓰기">
			</td>
		</tr>
	</table>
</form>

</body>
</html>
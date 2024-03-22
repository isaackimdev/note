<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
#passForm {
	width: 400px;
	margin: auto;
	border:1px solid orange;
}
</style>
</head>
<body>
<div id="passForm">
	<form action="boardDeletePro.do?board_num=${board_num}" method="post">
		<input type="hidden" name="page" value="${page}">
		<table>
			<tr>
				<td><label>글 비밀번호 : </label></td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제">&nbsp;&nbsp;
					<input type="button" value="돌아가기" 
						onclick="history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>












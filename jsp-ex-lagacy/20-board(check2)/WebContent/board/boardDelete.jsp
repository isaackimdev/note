<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script type="text/javascript">
function checkPass() {
	if(document.deleteCheckForm.board_pass.value == "") {
		alert("비밀번호를 입력하세요.");
		document.deleteCheckForm.board_pass.focus();
	} else {
		document.deleteCheckForm.submit();
	}
}
</script>
<style type="text/css">
#box {
	border:1px solid blue;
	width: 300px;
	margin:auto;
}
</style>
</head>
<body>
<div id="box">
<form action="boardDeletePro.do?page=${page }" name="deleteCheckForm" method="post">
		<!--  input type="hidden" name="page" value="${page }"> -->
		<input type="hidden" name="board_num" value="${board_num }">
	<table>
		<tr>
			<td><label>글 비밀번호 : </label></td>
			<td><input type="password" name="board_pass" id="board_pass">			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="삭제" onclick="checkPass()"> &nbsp;&nbsp;
				<input type="button" value="돌아가기" onclick="history.go(-1)">	<!-- history.back()도 됨 -->			
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
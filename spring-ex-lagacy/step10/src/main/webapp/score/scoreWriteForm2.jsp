<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<script type="text/javascript" src="../script/scoreScript.js"></script>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 200px;
}
.td_left {
	width:50px;
	background-color:orange; 
}
.td_right {
	width: 100px;
	background: skyblue;
}
</style>
</head>
<body>
<h2>성적입력</h2>
<form action="scoreWrite.jsp" method="post" name="scoreForm">
<table>
	<tr align="center">
		<td class="td_left"><label for="studNo">학번</label></td>
		<td class="td_right"><input type="text" name="studNo" id="studNo"></td>
	</tr>
	<tr align="center">
		<td class="td_left"><label for="name">이름</label></td>
		<td class="td_right"><input type="text" name="name" id="name"></td>
	</tr>
	<tr align="center">
		<td class="td_left"><label for="kor">국어</label></td>
		<td class="td_right"><input type="text" name="kor" id="kor"></td>
	</tr>
	<tr align="center">
		<td class="td_left"><label for="eng">영어</label></td>
		<td class="td_right"><input type="text" name="eng" id="eng"></td>
	</tr>
	<tr align="center">
		<td class="td_left"><label for="mat">수학</label></td>
		<td class="td_right"><input type="text" name="mat" id="mat"></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="button" value="등록" onclick="checkScoreWrite()">
			<input type="reset" value="다시쓰기" >
		</td>
	</tr>
</table>
</form>


</body>
</html>
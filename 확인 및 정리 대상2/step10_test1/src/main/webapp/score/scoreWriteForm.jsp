<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<style type="text/css">
#td_left {background-color:orange; text-align: center;}
body {
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript" src="../script/scoreScript.js"></script>
</head>
<body>

<div>
<h2>성적 입력</h2>
<form name="scoreWriteForm" id="scoreWriteForm" method="post" action="scoreWrite.jsp">
<table>
	<tr>
		<td id="td_left" width="40">학번</td>
		<td><input type="text" name="studNo" id="studNo"></td>
	</tr>
	<tr>
		<td id="td_left">이름</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>	
	<tr>
		<td id="td_left">국어</td>
		<td><input type="text" name="kor" id="kor"></td>
	</tr>	
	<tr>
		<td id="td_left">영어</td>
		<td><input type="text" name="eng" id="eng"></td>
	</tr>	
	<tr>
		<td id="td_left">수학</td>
		<td><input type="text" name="mat" id="mat"></td>
	</tr>	
	<tr>
		<td colspan="2">
			<input type="button" value="등록" onclick="writeFormCheck()">
			<input type="reset" value="다시쓰기">
		</td>
	</tr>		
</table>
</form>
</div>

</body>
</html>
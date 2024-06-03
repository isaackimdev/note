<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="helper.RegexHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ScoreDTO scoreDTO = (ScoreDTO)request.getAttribute("scoreDTO");
	//String studNo = (String)request.getAttribute("studNo");
	//int pg = (int)request.getAttribute("pg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적보기</title>
<style type="text/css">
tr {
	background: #ffffcc;
}
#tr_top {
	background: orange;
	text-align: center;
}
</style>
</head>
<body>

<table border="1" cellpadding="5">
	<tr id="tr_top">
		<td colspan="6">
			<font size="4">${scoreDTO.name}</font>
		</td>
	</tr>
	<tr align="center">
		<td width="100">학번</td>
		<td width="100">국어</td>
		<td width="100">영어</td>
		<td width="100">수학</td>
		<td width="100">총점</td>
		<td width="100">평균</td>
	</tr>
	<tr align="center">
		<td width="100">${scoreDTO.studNo}</td>
		<td width="100">${scoreDTO.kor}</td>
		<td width="100">${scoreDTO.eng}</td>
		<td width="100">${scoreDTO.mat}</td>
		<td width="100">${scoreDTO.tot}</td>
		<td width="100">${scoreDTO.avg}</td>
	</tr>
</table>

<input type="button" value="성적목록" onclick="location.href='scoreList.do?pg=${pg}'">
<input type="button" value="성적수정" onclick="location.href='scoreModify.jsp?pg=${pg}'">
<input type="button" value="성적삭제" 
		onclick="location.href='scoreDelete.do?pg=${pg}&studNo=${studNo}'">

</body>
</html>












<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="helper.RegexHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	request.setCharacterEncoding("utf-8");
	String studNo = request.getParameter("studNo");
	String str_pg = request.getParameter("pg");
	int pg = 1;
	if(RegexHelper.getInstance().isNum(str_pg)) {	// 정규표현식 사용
		pg = Integer.parseInt(str_pg);
	}
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(studNo);
	scoreDTO = scoreDAO.getScore(scoreDTO);
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
			<font size="4"><%=scoreDTO.getName() %></font>
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
		<td width="100"><%=scoreDTO.getStudNo() %></td>
		<td width="100"><%=scoreDTO.getKor() %></td>
		<td width="100"><%=scoreDTO.getEng() %></td>
		<td width="100"><%=scoreDTO.getMat() %></td>
		<td width="100"><%=scoreDTO.getTot() %></td>
		<td width="100"><%=scoreDTO.getAvg() %></td>
	</tr>
</table>

<input type="button" value="성적목록" onclick="location.href='scoreList.jsp?pg=<%=pg %>'">
<input type="button" value="성적수정" onclick="location.href='scoreModify.jsp?pg=<%=pg %>'">
<input type="button" value="성적삭제" 
		onclick="location.href='scoreDelete.jsp?pg=<%=pg %>&studNo=<%=studNo %>'">

</body>
</html>












<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	int pg = Integer.parseInt(request.getParameter("pg"));
	String studNo = request.getParameter("studNo");
	
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(studNo);
	
	ScoreDAO scoreDAO = new ScoreDAO();
	scoreDTO = scoreDAO.getScore(scoreDTO);

	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 성적 상세 보기</title>
</head>
<body>

<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	<tr>
		<td><%=scoreDTO.getStudNo() %></td>
		<td><%=scoreDTO.getName() %></td>
		<td><%=scoreDTO.getKor() %></td>
		<td><%=scoreDTO.getEng() %></td>
		<td><%=scoreDTO.getMat() %></td>
		<td><%=scoreDTO.getTot() %></td>
		<td><%=scoreDTO.getAvg() %></td>
	</tr>
</table>
<input type="button" value="목록" onclick="location.href='scoreList.jsp?pg=<%=pg%>'">
<input type="button" value="성적 수정" onclick="">
<input type="button" value="성적 삭제" 
	onclick="location.href='scoreDelete.jsp?pg=<%=pg%>&studNo=<%=studNo %>'">


</body>
</html>
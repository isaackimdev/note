<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	request.setCharacterEncoding("utf-8");
	String studNo = request.getParameter("studNo");
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(studNo);
	int su = scoreDAO.deleteScore(scoreDTO);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 삭제</title>
<script type="text/javascript">
	window.onload = function ()  {
		
		<% if (su > 0 ) { %> 
				alert("삭제 성공");
		<% } else { %>
				alert("삭제 실패");
		<% } %>
		location.href="scoreList.jsp?pg=<%=pg%>";
	}
</script>
</head>
<body>

</body>
</html>
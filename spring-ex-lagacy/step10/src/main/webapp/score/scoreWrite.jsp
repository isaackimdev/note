<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(request.getParameter("studNo"));
	scoreDTO.setName(request.getParameter("name"));
	scoreDTO.setKor(Integer.parseInt(request.getParameter("kor")));
	scoreDTO.setEng(Integer.parseInt(request.getParameter("eng")));
	scoreDTO.setMat(Integer.parseInt(request.getParameter("mat")));
	
	int tot = scoreDTO.getKor() + scoreDTO.getEng() + scoreDTO.getMat();
	scoreDTO.setTot(tot);
	scoreDTO.setAvg((double)tot/3);

	ScoreDAO scoreDAO = new ScoreDAO();
	int result = scoreDAO.insertScore(scoreDTO);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적등록</title>
<script type="text/javascript">
	window.onload = function() {
		<% if(result > 0) { %>
			alert("성적 등록 성공");
			location.href="scoreList.jsp?pg=1";
		<% } else { %>
			alert("성적 등록 실패");
			location.href="scoreWriteForm.jsp";
		<% } %>
	} 
</script>
</head>
<body>
	<% if(result > 0) { %>
		<p>성적등록 성공</p>
	<% } else { %>
		<p>성적등록 실패</p>
	<% } %>
</body>
</html>
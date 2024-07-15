<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("UTF-8");
	String studNo = request.getParameter("studNo");
	int pg = Integer.parseInt(request.getParameter("pg"));

	ScoreDTO dto = new ScoreDTO();
	ScoreDAO dao = new ScoreDAO();
	dto.setStudNo(studNo);
	int result = dao.deleteScore(dto);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적삭제</title>
<script type="text/javascript">
	window.onload = function() {
	<%if (result > 0) { %>
		alert("삭제완료");
		location.href="scoreList.jsp?pg=<%=pg %>";
	<% } else { %>
		alert("삭제실패")
		location.href="history.back()";
	<% } %>
	}
</script>
</head>
<body>
	<%if (result > 0) { %>
		<p>삭제 완료</p>
	<% } else { %>
		<p>삭제실패</p>
	<% } %>
</body>
</html>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int su = (int) request.getAttribute("su"); 
	int pg = (int) request.getAttribute("pg");
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
		location.href="scoreList.do?pg=<%=pg%>";
	}
</script>
</head>
<body>

</body>
</html>
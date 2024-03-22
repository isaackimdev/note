<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = 1; // Integer.parseInt(request.getParameter("pg"));
	if(request.getParameter("pg") != null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	// DB
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardDelete(seq);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script type="text/javascript">
	window.onload = function() {
		<% if(su>0) { %>
				alert("삭제 성공");
		<% } else { %>
				alert("삭제 실패");
		<% } %>
		location.href="boardList.jsp?pg=<%=pg%>";
	}
</script>
</head>
<body>

</body>
</html>
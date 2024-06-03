<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	//DB - delete
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardDelete(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
	<% 	if(su > 0) {%>
		alert("삭제 성공");
		location.href="boardList.jsp?pg=1";
	<%	} else { %>
		alert("삭제 실패");
		history.back();
	<% 	} %>
	}
</script>
</head>
<body>

</body>
</html>









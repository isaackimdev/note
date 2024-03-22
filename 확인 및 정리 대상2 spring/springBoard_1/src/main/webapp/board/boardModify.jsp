<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setSeq(seq);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	// int su = boardDAO.boardModify(boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<script type="text/javascript">
	window.onload = function() {
		<%//	if(su > 0) { %>
				alert("작성하신 글을 수정하였습니다.");
		<%//	} else { %>
				alert("작성하신 글을 수정하지 못하였습니다.");
		<%//	} %>
		location.href="boardList.jsp?pg=<%=pg %>"
	}
</script>
</head>
<body>

</body>
</html>












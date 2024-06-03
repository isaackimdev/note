<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터베이스에 한글이 깨지지 않도록 인코딩 설정
	request.setCharacterEncoding("UTF-8");
	//데이터
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String id = (String) session.getAttribute("memId");
	String name = (String) session.getAttribute("memName");
	// 데이터 지정
	// 데이터의 개수가 많기 때문에 자바빈즈 클래스에 담아서 전달
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setId(id);
	boardDTO.setName(name);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	// DB
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardWrite(boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<%	if(su > 0) { %>
		<p>작성하신 글을 저장하였습니다.</p>
<%	} else { %>
		<p>작성하신 글을 저장하지 못했습니다.</p>
<%	} %>
<%--
	글쓴이 : <%=name %><br>
	제목 : <%=subject %><br>
	내용 : <%=content %><br>
--%>	
</body>
</html>










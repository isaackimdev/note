<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO boardDTO = (BoardDTO) request.getAttribute("boardDTO");
	
	int seq = (int) request.getAttribute("seq"); // 공유 걸어온 데이터를 끄집어냄
	int pg = (int) request.getAttribute("pg");

	// 아직 EL , JSTL을 안쓰기 때문에 java, html 코드 공존 = JSP....
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 보기 </title>
</head>
<body>
<table border="1" cellpadding="5">
	<tr>
		<td colspan="3">
			<font size="5"><%=boardDTO.getSubject() %></font>
		</td>
	</tr>
	<tr align="center">
		<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
		<td width="150">작성자 : <%=boardDTO.getName() %></td>
		<td width="150">조회수 : <%=boardDTO.getHit() %></td>
	</tr>
	<tr>
		<td colspan="3" height="200" valign="top">
			<pre><%=boardDTO.getContent() %></pre>
		</td>
	</tr>
</table>
<input type="button" value="목록" 
		onclick="location.href='boardList.do?pg=<%=pg%>'">
<% if(session.getAttribute("memId").equals(boardDTO.getId())) { %>		
<input type="button" value="글수정">
<input type="button" value="글삭제"
		onclick="location.href='boardDelete.do?seq=<%=seq%>&pg=<%=pg %>'">
<% } %>

</body>
</html>
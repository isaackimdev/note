<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("list");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalP = (int) request.getAttribute("totalP");
	int pg = (int) request.getAttribute("pg");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
#subjectA:link {color:black; text-decoration: none;}
#subjectA:visited {color:black; text-decoration: none;}
#subjectA:hover {color:green; text-decoration: underline;}
#subjectA:active {color:black; text-decoration: none;}
#currentPaging {color:red; text-decoration: underline;}
#paging {color:blue; text-decoration: none;}
</style>

<script type="text/javascript">
	function isLogin(seq) {
		<% if(session.getAttribute("memId") == null) { %>
				alert("먼저 로그인 하세요!!");
		<% } else { %>
				location.href="boardView.do?seq=" + seq + "&pg="+ "<%=pg%>";
		<% } %>
	}
</script>
</head>
<body>

<table border="1" cellpadding="5">
	<tr bgcolor="ffff00">
		<th width="70">글번호</th>
		<th width="200">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="70">조회수</th>
	</tr>
<% for(BoardDTO boardDTO : list) { %>
	<tr align="center" bgcolor="ffffcc">
		<td><%=boardDTO.getSeq() %></td>
		<td>
			<a id="subjectA" href="#" onclick="isLogin(<%=boardDTO.getSeq() %>)">
				<%=boardDTO.getSubject() %>
			</a>
		</td>
		<td><%=boardDTO.getId() %></td>
		<td><%=boardDTO.getLogtime() %></td>
		<td><%=boardDTO.getHit() %></td>
	</tr>
<% } %>
	<tr>
		<td colspan="5" align="center">
	<% if(startPage > 3) { %>
			[<a id="paging" href="boardList.do?pg=<%=startPage-1%>">이전</a>]
	<% } %>
	<% for(int i=startPage; i<=endPage; i++ ) { 
			if(pg == i) {
		%>
				[<a id="currentPaging" href="boardList.do?pg=<%=i%>"><%=i %></a>]
		<% } else { %>
				[<a id="paging" href="boardList.do?pg=<%=i%>"><%=i %></a>]
		<% } %>
	<% }  %>
	
	<% if(endPage < totalP) { %>
			[<a id="paging" href="boardList.do?pg=<%=endPage+1%>">다음</a>]
	<% } %>		
		</td>
	</tr>
</table>
<br>
<a href="boardWriteForm.do">새글쓰기</a>
</body>
</html>
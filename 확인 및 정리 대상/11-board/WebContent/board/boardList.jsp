<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB - 1페이지당 5개씩
	// pg=1 rn>=1 and rn<=5
	// pg=2 rn>=6 and rn<=10
	// pg=3 rn>=11 and rn<=15
	int endNum = pg * 5;
	int startNum = endNum - 4;
	BoardDAO boardDAO = new BoardDAO();
	ArrayList<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	
	// 페이징 처리
	// 총글수 : 12
	// 총페이지수 : 3			[1][2][3]		=> (총글수+4)/5
				
	// 총글수 : 23
	// 총페이지수 : 5			[1][2][3][4][5]	
				
	// 총글수 : 25
	// 총페이지수 : 5			[1][2][3][4][5]		
	int totalA = boardDAO.getTotalA();	// 총글수 (Total Article number)
	int totalP = (totalA+4) / 5;		// 총페이지수

	// 3블럭
	//			[1][2][3][다음]
	//   [이전][4][5][6][다음]
	//   [이전][7][8]
	int startPage = (pg-1)/3*3 + 1;	//(2-1)/3*3 + 1 = 1
	int endPage = startPage + 2;
	if(totalP < endPage) endPage = totalP;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript">
	function isLogin(seq) {
		<%	if(session.getAttribute("memId") == null) { %>
				alert("먼저 로그인 하세요.");
		<%	} else { %>				
				location.href="boardView.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		<%	} %>
	}
</script>
<style type="text/css">
.subjectA:link {color: black; text-decoration: none;}
.subjectA:visited {color: black; text-decoration: none;}
.subjectA:active {color: black; text-decoration: none;}
.subjectA:hover {color: green; text-decoration: underline;}
a.paging {color: blue; text-decoration: none;}
a.currentPaging { color: red; text-decoration: underline;}
</style>
</head>
<body>
<table border="1" cellpadding="5">
	<tr bgcolor="#ffff00">
		<th width="70">글번호</th>
		<th width="200">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="70">조회수</th>
	</tr>
<%	for(BoardDTO boardDTO : list) { %>	
	<tr align="center" bgcolor="#ffffcc">
		<td><%=boardDTO.getSeq() %></td>
		<td align="left">
			<a class="subjectA" href="#" onclick="isLogin(<%= boardDTO.getSeq()%>); return false;">
				<%=boardDTO.getSubject() %>
			</a>
		</td>
		<td><%=boardDTO.getName() %></td>
		<td><%=boardDTO.getLogtime() %></td>
		<td><%=boardDTO.getHit() %></td>
	</tr>
<%	} %>	
	<tr>
		<td colspan="5" align="center">
			<!-- "이전" 글자 표시 여부 -->
			<% 	if(startPage > 3) {%>
					[<a class="paging" href="boardList.jsp?pg=<%=startPage - 1 %>">이전</a>]
			<%	} %>
			<!-- 페이징 처리 -->
			<%	for(int i=startPage; i<=endPage; i++) { %>
			<%		if(i == pg) { // 현재 페이지 %>
						[<a class="currentPaging" href="boardList.jsp?pg=<%=i %>"><%=i %></a>]
			<%		} else { %>
						[<a class="paging" href="boardList.jsp?pg=<%=i %>"><%=i %></a>]
			<%		} %>
			<%	} %>
			
			<!-- "다음" 글자 표시 여부 -->
			<%	if(endPage < totalP) { %>
					[<a class="paging" href="boardList.jsp?pg=<%=endPage + 1 %>">다음</a>]
			<%	} %>
		</td>
	</tr>
</table>
<a href="../main/index.jsp">메인 화면</a>
</body>
</html>















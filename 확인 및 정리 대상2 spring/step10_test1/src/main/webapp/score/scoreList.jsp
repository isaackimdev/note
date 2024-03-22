<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB - 1페이지당 5개씩
	int endNum = pg * 5 ; 		// 5, 10, 15....
	int startNum = endNum - 4;	// 1, 6, 11....
	ScoreDAO scoreDAO = new ScoreDAO();
	ArrayList<ScoreDTO> list = scoreDAO.getScoreList(startNum, endNum);
	// 페이징 처리
	int totalA = scoreDAO.getTotalA();	// 총글 수
	int totalP = (totalA + 4)/5;		// 총페이지 수
	// 페이징 3개씩 보여주기
	int startPage = (pg-1)/3*3 + 1;		//	1 , 4 , 7
	int endPage = startPage + 2 ;		// 3, 6, 9
	if(endPage > totalP) endPage=totalP;
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 목록 보기</title>
<style type="text/css">
#subjectA:link {color:black; text-decoration: none;}
#subjectA:visited {color:black; text-decoration: none;}
#subjectA:hover {color:green; text-decoration: underline;}
#subjectA:active {color:black; text-decoration: none;}
#currentPaging {color:red; text-decoration: underline;}
#paging {color:blue; text-decoration: none;}
</style>

</head>
<body>

<table>
	<tr bgcolor="orange">
		<th width="120">학번</th>
		<th width="100">이름</th>
		<th width="80">국어</th>
		<th width="80">영어</th>
		<th width="80">수학</th>
		<th width="80">총점</th>
		<th width="80">평균</th>
	</tr>
<% for (ScoreDTO scoreDTO : list) { %>
	<tr align="center" bgcolor="ffffcc">
		<td><%=scoreDTO.getStudNo() %></td>
		<td>
			<a id="nameA" href="scoreView.jsp?pg=<%=pg%>&studNo=<%=scoreDTO.getStudNo() %>">
				<%=scoreDTO.getName() %>
			</a>
		</td>
		<td><%=scoreDTO.getKor() %></td>
		<td><%=scoreDTO.getEng() %></td>
		<td><%=scoreDTO.getMat() %></td>
		<td><%=scoreDTO.getTot() %></td>
		<td><%=scoreDTO.getAvg() %></td>
	</tr>
<% } %>
	<tr>
		<td colspan="7" align="center">
	<% if (startPage > 3) { %>
			[<a id="paging" href="scoreList.jsp?pg=<%=startPage-1%>">이전</a>]
	<% } %>
	
	<% for(int i=startPage; i<=endPage; i++) { 		
			if( pg == i) {
		%>
			[<a id="currentPaging" href="scoreList.jsp?pg=<%=i %>"><%=i %></a>]
		<% } else { %>
			[<a id="paging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>]
		<% } %>
	<% } %>
	
	<% if(endPage < totalP) { %>
			[<a id="paging" href="scoreList.jsp?pg=<%=endPage+1 %>">다음</a>]
	<% } %>
		</td>
	</tr>
</table>
<a href="scoreWriteForm.jsp">성적입력</a>
</body>
</html>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="helper.RegexHelper"%>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ScoreDTO> list = null;
	int pg = 1;
	int limit = 5;
	String str = request.getParameter("pg");
	// 문자열을 숫자로 변환할 때
	// 1. null 확인 2. 숫자만으로 구성되었는지 => ★정규표현식으로 검사★		
	if(RegexHelper.getInstance().isNum(str)) {
		pg = Integer.parseInt(str);
	}
	int endNum = pg * limit;				// 5, 10, 15..
	int startNum = endNum - (limit - 1);	// 1, 6, 11..
	
	ScoreDAO scoreDAO = new ScoreDAO();
	list = (ArrayList<ScoreDTO>)scoreDAO.getScoreList(startNum, endNum);	// 값들을 list에 담는다. 다섯개씩
	
	int listCount = scoreDAO.selectListCount();	// 총 갯수를 가지고 온다.
	
	int maxPage = (listCount + limit - 1 ) / limit;		// (26 + 5 - 1) / 5
	int startPage = (pg-1)/3*3+1;
	int endPage = startPage + 2;
	if(endPage > maxPage) endPage = maxPage;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 목록</title>
<style type="text/css">
#listForm {
	width: 500px;
	height: 160px;
	margin: auto;
}
h2 { text-align: center;}
table{margin: auto; width:450px; }
#tr_top {background: orange; text-align: center;}
#currentPaging {
	color: red;
	text-decoration: underline;
}
#paging {
	color: blue;
	text-decoration: none;
}
#name:link {color: black; text-decoration: none;}
#name:visited {color: black; text-decoration: none;}
#name:active {color: black; text-decoration: none;}
#name:hover {color: green; text-decoration: underline;}


</style>
</head>
<body>
<h2>성적 목록</h2>
<div id="listForm">
<table>
	<tr id="tr_top">
		<th>학번</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	
	<!-- for문 써서 값 불어내기 -->
<% for (ScoreDTO scoreDTO : list) { %>
	<tr bgcolor="ffffcc" align="center">
		<td><%=scoreDTO.getStudNo() %></td>
		<td>
			<a id="name" href="scoreView.jsp?studNo=<%=scoreDTO.getStudNo()%>&pg=<%=pg%>">
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
	<!-- 페이징처리 -->
	<tr>
		<td colspan="7" align="center">
	
<%if(startPage > 3) { %>	
		[<a id="paging" href="scoreList.jsp?pg=<%=startPage - 1 %>">이전</a>]
<%} %>
	
<% for(int i = startPage; i <= endPage; i++) { %>
	<%if(i == pg) { %>
		[<a id="currentPaging" href="scoreList.jsp?pg=<%=i %>"><%=i %></a>]
	<% } else {%>
		[<a id="paging" href="scoreList.jsp?pg=<%=i %>"><%=i %></a>]
	<% }  %>
<% } %>	

<%if(endPage < maxPage) { %>		
		[<a id="paging" href="scoreList.jsp?pg=<%=endPage + 1 %>">다음</a>]
<% } %>
	
	
		</td>
	</tr>
	
</table>

<a href="scoreWriteForm.jsp">성적입력</a>
</div>
</body>
</html>











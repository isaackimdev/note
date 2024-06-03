<%@page import="score.dao.ScoreDAO"%>
<%@page import="helper.RegexHelper"%>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	//ArrayList<ScoreDTO>list =(ArrayList<ScoreDTO>) request.getAttribute("list");
	//int endPage= (int) request.getAttribute("endPage");
	//int startPage= (int) request.getAttribute("startPage");
	//int maxPage= (int) request.getAttribute("maxPage");
	//int pg= (int) request.getAttribute("pg");
	
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
	
<c:forEach var="scoreDTO" items="${list }">
		<tr bgcolor="ffffcc" align="center">
		<td>${scoreDTO.studNo}</td>
		<td>
			<a id="name" href="scoreView.do?studNo=${scoreDTO.studNo}&pg=${pg}">
				${scoreDTO.name}
			</a>
		</td>
		<td>${scoreDTO.kor}</td>
		<td>${scoreDTO.eng}</td>
		<td>${scoreDTO.mat}</td>
		<td>${scoreDTO.tot}</td>
		<td>${scoreDTO.avg}</td>
	</tr>
</c:forEach>


	<!-- 페이징처리 -->
	<tr>
		<td colspan="7" align="center">
		
		<c:if test="${startPage > 3 }">
				[<a id="paging" href="scoreList.do?pg=${startPage - 1 }">이전</a>]
		</c:if>
		
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<c:if test="${i == pg }">
				[<a id="currentPaging" href="scoreList.do?pg=${i}">${i}</a>]
		</c:if>
		
		<c:if test="${i != pg }">
			[<a id="paging" href="scoreList.do?pg=${i}">${i}</a>]
		</c:if>
		
	</c:forEach>		
	
		<c:if test="${endPage < maxPage }">
				[<a id="paging" href="scoreList.do?pg=${endPage + 1 }">다음</a>]
		</c:if>
			
		</td>
	</tr>
	
</table>

<a href="scoreWriteForm.do">성적입력</a> <!-- do 로 할 경우 보안에 좋다. -->
</div>
</body>
</html>











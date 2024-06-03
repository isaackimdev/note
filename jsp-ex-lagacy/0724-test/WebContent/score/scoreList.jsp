<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>◈ Score List ◈</title>
<style type="text/css">
#listForm {
	width: 600px;
	height: 260px;
	border:1px solid lightGray;
	margin: auto;
}
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 500px;
}
#tr_top {
	background: lightGray;
	text-align: center;
}
#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}
.paging {
	color: blue;
	text-decoration: none;
}
.currentPaging {
	color: red;
	text-decoration: underline;
}
</style>
</head>
<body>
<h2> 성적 목록 </h2>

<div id="listForm">
	
	<table>
		<tr id="tr_top">
			<td>학번</td>
			<td>이름</td>
			<td>국어점수</td>
			<td>영어점수</td>
			<td>수학점수</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
<c:forEach var="scoreDTO" items="${list }">
	<tr align="center">
		<td>${scoreDTO.score_num }</td>
		<td>${scoreDTO.score_name }</td>
		<td>${scoreDTO.score_kor }</td>
		<td>${scoreDTO.score_eng }</td>
		<td>${scoreDTO.score_mat }</td>
		<td>${scoreDTO.score_tot }</td>
		<td>${scoreDTO.score_avg }</td>
	</tr>
</c:forEach>
	</table>
</div>

<div id="pageList">
<c:if test="${pageInfo.page > 3}" >
	[<a class="paging" href="scoreList.do?page=${pageInfo.startPage - 1}">이전</a>]&nbsp;
</c:if>	

<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }"
			step="1">
	<c:if test="${a == pageInfo.page }">			
		[<a class="currentPaging" href="scoreList.do?page=${a}">${a}</a>]
	</c:if>	
	
	<c:if test="${a != pageInfo.page }">			
		[<a class="paging" href="scoreList.do?page=${a}">${a}</a>]
	</c:if>		
</c:forEach>
	&nbsp;
<c:if test="${pageInfo.endPage < pageInfo.maxPage}" >	
	[<a class="paging" href="scoreList.do?page=${pageInfo.endPage + 1}">다음</a>]
</c:if>	
</div>
<br>

</body>
</html>
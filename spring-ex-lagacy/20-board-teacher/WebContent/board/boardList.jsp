<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
	width: 500px;
	height: 250px;
	border: 1px solid lightGray;
	margin: auto;
}
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 450px;
}
#tr_top {
	background: orange;
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
<h2>글 목록</h2>
<div id="listForm">
	<table>
		<tr id="tr_top">
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
<c:forEach var="boardBean" items="${list }">
		<tr align="center">
			<td>${boardBean.board_num }</td>
			<td align="left">
				<c:if test="${boardBean.board_re_lev != 0}">
					<c:forEach var="a" begin="0" end="${boardBean.board_re_lev*2}" step="1">
						&nbsp;
					</c:forEach>
				</c:if>
				<a href="boardDetail.do?board_num=${boardBean.board_num}&page=${pageInfo.page}">
					▶${boardBean.board_subject }</a>
			</td>
			<td>${boardBean.board_name }</td>
			<td>${boardBean.board_date }</td>
			<td>${boardBean.board_readcount }</td>
		</tr>
</c:forEach>		
	</table>
</div>

<div id="pageList">
<c:if test="${pageInfo.page > 3}" >
	[<a class="paging" href="boardList.do?page=${pageInfo.startPage - 1}">이전</a>]&nbsp;
</c:if>	

<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }"
			step="1">
	<c:if test="${a == pageInfo.page }">			
		[<a class="currentPaging" href="boardList.do?page=${a}">${a}</a>]
	</c:if>	
	
	<c:if test="${a != pageInfo.page }">			
		[<a class="paging" href="boardList.do?page=${a}">${a}</a>]
	</c:if>		
</c:forEach>
	&nbsp;
<c:if test="${pageInfo.endPage < pageInfo.maxPage}" >	
	[<a class="paging" href="boardList.do?page=${pageInfo.endPage + 1}">다음</a>]
</c:if>	
</div>
<br>

<div align="center">
	<a href="/20-board/index.jsp">메인 화면</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="boardWriteForm.do">게시판 글쓰기</a>
</div>
</body>
</html>









<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.currentPaging {
	color: red;
	text-decoration:  underline;
}
.paging {
	color: blue;
	text-decoration:  none;
}
</style>
</head>
<body>
<table border="1">
	<tr>
		<th width="50">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
<c:forEach var="imageboard" items="${list}">	
	<tr align="center">
		<td>${imageboard.seq}</td>
		<td><a href="imageboardView.jsp?seq=${imageboard.seq}&pg=${pg}">
				<img src="../storage/${imageboard.image1}" width="50" height="50">
			</a>	
		</td>
		<td>${imageboard.imageName}</td>
		<td>${imageboard.imagePrice}</td>
		<td>${imageboard.imageQty}</td>
		<td>${imageboard.imagePrice * imageboard.imageQty}</td>
	</tr>
</c:forEach>	
	<!-- 페이징 -->
	<tr>
		<td colspan="6" align="center">
			<c:if test="${startPage > 3}">
				[<a class="paging" href="imageboardList.jsp?pg=${startPage - 1 }">이전</a>]
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					[<a class="currentPaging" href="imageboardList.jsp?pg=${i }">${i }</a>]
				</c:if>
				
				<c:if test="${i != pg }">
					[<a class="paging" href="imageboardList.jsp?pg=${i }">${i }</a>]
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage < totalP }">
				[<a class="paging" href="imageboardList.jsp?pg=${endPage + 1 }">다음</a>]
			</c:if>
		</td>
	</tr>	
</table>	
</body>
</html>



















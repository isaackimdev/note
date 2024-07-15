<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	</tr>
<c:forEach var="guestbookDTO" items="${list}">
	<tr align="center" bgcolor="#ffffcc">
		<td>${guestbookDTO.guest_num}</td>
		<td align="left">
			<a class="subjectA" href="#">
				${guestbookDTO.guest_subject}
			</a>
		</td>
		<td>${guestbookDTO.guest_writer}</td>
		<td>${guestbookDTO.logtime}</td>
	</tr>
</c:forEach>	
	<tr>
		<td colspan="5" align="center">
			<!-- "이전" 글자 표시 여부 -->
			<c:if test="${startPage > 3 }">
				[<a class="paging" href="guestbookList?pg=${startPage - 1 }">이전</a>]
			</c:if>
			
			
			<!-- 페이징 처리 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					[<a class="currentPaging" href="guestbookList?pg=${i}">${i}</a>]
				</c:if>
				
				<c:if test="${i != pg }">
					[<a class="paging" href="guestbookList?pg=${ i}">${i}</a>]		
				</c:if>
			</c:forEach>
					
			<!-- "다음" 글자 표시 여부 -->
			<c:if test="${endPage < totalP }">
				[<a class="paging" href="guestbookList?pg=${endPage + 1}">다음</a>]
			</c:if>
		</td>
	</tr>
</table>


</body>
</html>
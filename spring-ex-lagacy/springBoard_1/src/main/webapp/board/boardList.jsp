<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				location.href="boardView?seq=" + seq + "&pg=" + ${pg };
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
	
<c:forEach var="boardDTO" items="${list }">
	<tr align="center" bgcolor="#ffffcc">
		<td>${boardDTO.seq} </td>
		<td align="left">
			<a class="subjectA" href="#" onclick="isLogin(${boardDTO.seq}); return false;">
				${boardDTO.subject}
			</a>
		</td>
		<td>${boardDTO.name}</td>
		<td>${boardDTO.logtime}</td>
		<td>${boardDTO.hit}</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="5" align="center">
		<!-- "이전" 글자 표시 여부 -->	
		<c:if test="${startPage > 3 }">
			[<a class="paging" href="boardList?pg=${startPage - 1 }">이전</a>]		
		</c:if>
		
		<!-- 페이징 처리 -->
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${ pg == i}"> <!-- 현재페이지 -->
				[<a class="currentPaging" href="boardList?pg=${i}">${i}</a>]	
			</c:if>
			
			<c:if test="${ pg != i }">
				[<a class="paging" href="boardList?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>
			
		<!-- "다음" 글자 표시 여부 -->
		<c:if test="${endPage < totalP }">
				[<a class="paging" href="boardList.jsp?pg=${endPage + 1}">다음</a>]	
		</c:if>
	
		</td>
	</tr>
</table>
<a href="../main/index">메인 화면</a>
</body>
</html>















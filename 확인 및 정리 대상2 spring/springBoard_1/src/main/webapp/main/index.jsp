<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h2>*** 메인 화면 ***</h2><br>

<c:if test="${sessionScope.memId == null}">	
	<a href="../member/writeForm">회원가입</a><br>	<!-- 동작 완료 -->
	<a href="../member/loginForm">로그인</a><br>		<!-- 동작 완료 -->
</c:if>
<c:if test="${sessionScope.memId != null}">	
	<a href="../member/logout">로그아웃</a><br>		<!-- 동작 완료 -->
	<a href="../member/modifyForm.jsp">회원정보수정</a><br>
	<a href="../board/boardWriteForm">글쓰기</a><br>	<!-- 동작 완료 -->
</c:if>
	<a href="../board/boardList?pg=1">목록</a> 	<!-- 동작 완료 -->
</body>
</html>











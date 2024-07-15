<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h2>*** 메인 화면 ***</h2><br>
<c:if test="${sessionScope.memId == null }">	<!-- 로그인 전 -->
	<a href="../member/writeForm.do">회원가입</a><br>
	<a href="../member/loginForm.do">로그인</a><br>
</c:if>

<c:if test="${sessionScope.memId != null }">	<!-- 로그인 후 -->
	<a href="../member/logout.do">로그아웃</a><br>
	<a href="../member/modifyForm.do">회원정보수정</a><br>
	<a href="../board/boardWriteForm.do">글쓰기</a><br>
</c:if>
	<a href="../board/boardList.do?pg=1">목록</a>

</body>
</html>











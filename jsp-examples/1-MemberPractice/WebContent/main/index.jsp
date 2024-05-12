<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>*** 메인화면(게시판)***</title>
</head>
<body>

<h2>*** 메인 화면 ***</h2>
<% if(session.getAttribute("memId")==null) { // 로그인 전%>
<a href="../member/writeForm.jsp">회원가입</a><br>
<a href="../member/loginForm.jsp">로그인</a><br>
<% } else { %>
<a href="../member/logout.jsp">로그아웃</a><br>
<a href="#">회원정보수정</a><br>
<% } %>
	
</body>
</html>
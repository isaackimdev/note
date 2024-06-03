<%@page import="member.dao.Member2DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그인 폼으로부터 데이터 전달 받기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// DB
	Member2DAO member2DAO = new Member2DAO();
	String name = member2DAO.login(id, pwd);
	
	if(name == null) {
		// 로그인 실패
		response.sendRedirect("/0713-TEST/main/index.jsp?req=loginFail");
	} else {
		// 로그인 성공
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		response.sendRedirect("/0713-TEST/main/index.jsp?req=loginOk");
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Data 처리</title>
</head>
<body>

</body>
</html>
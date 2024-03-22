<%@page import="member.dao.Member2DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터
	String id = request.getParameter("id");
	// DB
	Member2DAO member2DAO = new Member2DAO();
	boolean exist = member2DAO.isExistId(id);
	
	// 데이터 공유
	request.setAttribute("id", id);
	request.setAttribute("exist", exist);
	// 페이지 이동
	RequestDispatcher dispatcher
	 = request.getRequestDispatcher("checkIdResult.jsp");
	dispatcher.forward(request, response);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>

</body>
</html>
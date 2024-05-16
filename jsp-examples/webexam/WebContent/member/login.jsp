<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// DB CHECK 했다고 치고.
	// MemberDAO memberDAO = new MemberDAO();
	// String name = memberDAO.login(id, pwd);
	// name으로 로그인 체크
	// name이 없으면 
	// response.sendRedirect("loginFail.jsp");	
	
	// 쿠키 사용
	Cookie cookie = new Cookie("id", URLEncoder.encode(id, "UTF-8"));
	cookie.setMaxAge(60); // 60초 설정
	response.addCookie(cookie);	// 쿠키 저장
	
	// 세션 사용
	session.setAttribute("id", id);
	response.sendRedirect("loginOk.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<h2>login page</h2>


</body>
</html>
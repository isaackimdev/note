<%@page import="java.net.URLEncoder"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터 읽어오기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// DB
	MemberDAO memberDAO = new MemberDAO();
	String name = memberDAO.login(id, pwd);
	
	if(name == null) { 	
		// 페이지 이동
		response.sendRedirect("/17-imageboard/main/index.jsp?req=loginFail");
	} else { 
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		response.sendRedirect("/17-imageboard/main/index.jsp?req=loginOk");
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

</body>
</html>












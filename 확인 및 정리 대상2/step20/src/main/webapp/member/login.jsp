<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터 읽어오기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// DB
	MemberDAO memberDAO = new MemberDAO();
	String name = memberDAO.login(id, pwd);
	
	if(name == null) {	// 로그인 실패
		response.sendRedirect("loginForm.jsp");
	}	else {		// 로그인 성공
		session.setAttribute("memId", id);
		session.setAttribute("memName", name);
		response.sendRedirect("../board/boardList.jsp?pg=1");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
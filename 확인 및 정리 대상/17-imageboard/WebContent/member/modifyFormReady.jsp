<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	// DB
	String id = (String)session.getAttribute("memId");
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = memberDAO.getMember(id);
	// 데이터 공유
	request.setAttribute("memberDTO", memberDTO);
	// 페이지 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=modifyForm");
	dispatcher.forward(request, response);
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>
<%
	// 데이터 저장
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// 아이디 일치하는지 확인
	
	MemberDAO memberDAO = new MemberDAO();
	String name = memberDAO.login(id, pwd);
//	String loginName = memberDTO.getName();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<% if(name == null) { %>
	<p>아이디 또는 비밀번호가 틀렸으니 다시 로그인 하세요.</p>
<% } else {%>
	<p>	<%=name %> 님이 로그인 </p>	
<% } %>

</body>
</html>
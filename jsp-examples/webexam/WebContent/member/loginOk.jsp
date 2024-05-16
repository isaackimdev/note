<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// 쿠키, 세션 꺼내기
	Cookie[] cookies = request.getCookies();

	String idByCookie = ""; 
	String idBySession = "";
	
	if (cookies != null) {
		for (int i = 0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("id")) {
				idByCookie = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
			}
		}
	}
	
	idBySession = (String) session.getAttribute("id");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login ok page</title>
</head>
<body>
	
	<a href="../main/index.jsp">index</a>
	
	<h2>login ok page</h2>
	cookie id : <%=idByCookie %> <br>
	session id : <%=idBySession %> <br>
	
	<input type="button" value="logout" onclick="location.href='logout.jsp'">
	
</body>
</html>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%	if(name == null) { 	
		// 페이지 이동
		response.sendRedirect("loginFail.jsp");
	} else { 			
		// 페이지 이동
		// get 방식으로 이동되기 때문에 이름과 id가 오픈되기 때문에 get 방식으로 보내면 안됨
		// 쿠키나 세션으로 보내야 함.
		//response.sendRedirect("loginOk.jsp?name="+URLEncoder.encode(name, "utf-8")
		//										+"&id=" + id);
		/* 쿠기를 이용한 페이지 이동*/		
/*		
		Cookie cookie = new Cookie("memName", URLEncoder.encode(name, "UTF-8"));
		cookie.setMaxAge(60);	// 60초 설정
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("memId", id);
		cookie.setMaxAge(60);
		response.addCookie(cookie2);
		
		response.sendRedirect("loginOk.jsp");
*/		
		/* 세션를 이용한 페이지 이동*/		
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		response.sendRedirect("loginOk.jsp");
	} 
%>	
</body>
</html>












<%@page import="java.net.URLEncoder"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 가져오기
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// 아이디 패스워드 일치여부 확인하기 > DB랑
	// 1. db사용하기 위한 JDBC 클래스 호출
	MemberDAO memberDAO = new MemberDAO();
	// DB검색하기 함수 만들기 
	String name = memberDAO.login(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(서버)</title>
</head>
<body>
<% if(name == null) { 
	response.sendRedirect("loginFail.jsp");	
 	} else {
 	// 페이지 이동
 	// get 방식으로 이동되기 때문에 이름과 id가 오픈되기 떄문에 get 방식으로 보내면 안됨
 	// 쿠키나 세션으로 보내야 함.
 	//response.sendRedirect("loginOk.jsp?name="+URLEncoder.encode(name, "utf-8")
 	//						+"&id="+id);
 	
 	/*  쿠키 사용하기    */
 	/*
 	
 	Cookie cookie = new Cookie("memName", URLEncoder.encode(name, "UTF-8"));
 	cookie.setMaxAge(60); // 60초 유지 설정
 	response.addCookie(cookie);	//쿠키를 저장해 둠
 	
 	Cookie cookie2 = new Cookie("memId", id);	// 아이디는 영문과 숫자니까 그냥 저장
 	cookie.setMaxAge(60);
 	response.addCookie(cookie2);
 	
 	response.sendRedirect("loginOk.jsp");
 	
 	*/
 	/*   세션을 이용한 페이지 이동    */
 	session.setAttribute("memName", name);
 	session.setAttribute("memId", id);
 	response.sendRedirect("loginOk.jsp");
 	
 } %>

</body>
</html>
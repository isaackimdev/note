<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.setAttribute("apple","사과s");
	request.setAttribute("apple","사과r");
	application.setAttribute("apple","사과a");

	// 페이지 이동 - forward와 같은 의미
	// 반드시 상태번지를 사용해야 한다.
	RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
	dispatcher.forward(request, response);
	
	
%>
<%-- 
<jsp:forward page="forwardResult.jsp"/>
 --%>

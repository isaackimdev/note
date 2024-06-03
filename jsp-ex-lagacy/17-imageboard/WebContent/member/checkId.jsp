<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터
	String id = request.getParameter("id");
	// DB
	MemberDAO memberDAO = new MemberDAO();
	boolean exist = memberDAO.isExistId(id);	
	// 데이터 공유
	request.setAttribute("id", id);
	request.setAttribute("exist", exist);
	// 페이지 이동
	RequestDispatcher dispatcher
	 = request.getRequestDispatcher("checkIdResult.jsp");
	dispatcher.forward(request, response);
%>













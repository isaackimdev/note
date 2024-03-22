<%@page import="member.dao.Member2DAO"%>
<%@page import="member.bean.Member2DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 읽어오기
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	int birth = Integer.parseInt(request.getParameter("birth"));
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String addr = request.getParameter("addr");
	// 데이터 저장 
	Member2DTO member2DTO = new Member2DTO();
	member2DTO.setId(id);
	member2DTO.setPwd(pwd);
	member2DTO.setName(name);
	member2DTO.setBirth(birth);
	member2DTO.setGender(gender);
	member2DTO.setEmail1(email1);
	member2DTO.setEmail2(email2);
	member2DTO.setTel1(tel1);
	member2DTO.setTel2(tel2);
	member2DTO.setTel3(tel3);
	member2DTO.setAddr(addr);
	// DB
	Member2DAO member2DAO = new Member2DAO();
	int su = member2DAO.write(member2DTO);
	// 데이터 공유
	request.setAttribute("su", su);
	// 페이지 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=writeResult");
	dispatcher.forward(request, response);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 처리</title>

</head>
<body>

</body>
</html>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%
	//데이터 읽어오기
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String addr = request.getParameter("addr");
	//데이터 저장
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setTel1(tel1);
	memberDTO.setTel2(tel2);
	memberDTO.setTel3(tel3);
	memberDTO.setAddr(addr);
	//DB
	MemberDAO memberDAO = new MemberDAO();
	int su = memberDAO.modify(memberDTO);
	// 데이터 공유
	request.setAttribute("su", su);
	// 페이지 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=modifyResult");
	dispatcher.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>

<%--
이름 : <%=name %><br>
아이디 : <%=id %><br>
비밀번호 : <%=pwd %><br>
성별 : <%=gender %><br>
이메일 : <%=email1 %>@<%=email2 %><br>
핸드폰 : <%=tel1 %>-<%=tel2 %>-<%=tel3 %><br>
주소 : <%=addr %><br>
 --%>
</body>
</html>











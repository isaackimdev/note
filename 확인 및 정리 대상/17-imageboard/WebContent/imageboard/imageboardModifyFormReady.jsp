<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	ImageboardDTO imageboardDTO = imageboardDAO.imageboardView(seq);
	// 공유 설정
	request.setAttribute("seq", seq);
	request.setAttribute("pg", pg);
	request.setAttribute("imageboardDTO", imageboardDTO);
	// 화면이동 : index.jsp에 포함시켜야함
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyForm");
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

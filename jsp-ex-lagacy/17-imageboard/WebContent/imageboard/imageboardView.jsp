<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	ImageboardDTO imageboardDTO = imageboardDAO.imageboardView(seq);
	// 데이터 공유 시킴
	request.setAttribute("seq", seq);
	request.setAttribute("pg", pg);
	request.setAttribute("imageboardDTO", imageboardDTO);
	// 페이지 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=imageboardViewResult");
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




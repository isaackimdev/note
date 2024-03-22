<%@page import="java.util.ArrayList"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB - 1페이지당 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	ArrayList<ImageboardDTO> list = imageboardDAO.imageboardList(startNum, endNum);
	
	//페이징 처리
	//총글수 : 12
	//총페이지수 : 3			[1][2][3]		=> (총글수+4)/5
			
	//총글수 : 23
	//총페이지수 : 5			[1][2][3][4][5]	
			
	//총글수 : 25
	//총페이지수 : 5			[1][2][3][4][5]	
	int totalA = imageboardDAO.getTotalA();		// 총글수
	int totalP = (totalA + 4) / 5;				// 총페이지수
	
	// 3블럭
	//	    [1][2][3][다음]
	//[이전][4][5][6][다음]
	//[이전][7][8]
	//pg=1		startPage=1		endPage=3
	//pg=2		startPage=1		endPage=3
	//pg=3		startPage=1		endPage=3
	
	//pg=4		startPage=4		endPage=6
	//pg=7		startPage=7		endPage=8
	int startPage = (pg-1)/3*3+1;	// (2-1)/3*3+1 = 1
	int endPage = startPage + 2;
	if(totalP < endPage) endPage = totalP;
	
	// 응답 쪽 공유 데이터 설정
	request.setAttribute("pg", pg);
	request.setAttribute("list", list);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	request.setAttribute("totalP", totalP);
	// 페이지 이동
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
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




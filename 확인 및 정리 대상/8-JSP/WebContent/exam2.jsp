<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%
	Date date = new Date();								// 현재 날짜
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");	// 형식에 맞게
	String strDate = simpleDateFormat.format(date); 	// 형식을 지정하는 클래 것
%>	<!-- 일반적으로 HTML 윗쪽에 배치함. 실습 및 보여주기 위해서는 아래쪽에 사용 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

오늘 날짜는 <%=strDate %>입니다. <!-- JSP 자바 표현식 -->
</body>
</html>
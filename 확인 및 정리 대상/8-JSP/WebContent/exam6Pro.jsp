<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String areaNum = request.getParameter("areaNum");
	String tel = request.getParameter("tel");
	String result = name + "님의 전화번호는" +areaNum + "-" + tel + " 입니다.";
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=result %> <br>
	<%=name %> 님의 전화번호는 <%=areaNum %>-<%=tel %> 입니다.

</body>
</html>
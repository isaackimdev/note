<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	double num1 = Double.parseDouble(request.getParameter("num1"));
	double num2 = Double.parseDouble(request.getParameter("num2"));
	String op = request.getParameter("op");
	double result = 0;
	
	switch(op) {
	case "+" :result= num1 + num2; break;
	case "-" :result= num1 - num2; break;
	case "*" :result= num1 * num2; break;
	case "/" :result= num1 / num2; break;		
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<%=num1 %> <%=op %> <%=num2 %> = <%=result %>
</body>
</html>
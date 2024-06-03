<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strNumber1 = request.getParameter("number1");
	String strNumber2 = request.getParameter("number2");
	int number1 = Integer.parseInt(strNumber1);
	int number2 = Integer.parseInt(strNumber2);
%>    <!-- 문자열로 데이터가 넘어오게 됨... 넘어오는 데이터  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=number1 %> +<%=number2 %> = <%=number1 + number2 %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 장점 : EL표현식은 자료형에 자유롭다. -->
<!--  el 표현식은 JSP표현식을 대체하면서	application, request, session 객체의 기능 등을 대체 합니다. -->
${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }<br>
${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }<br>
${param.x } * ${param.y } = ${param.x * param.y }<br>
${param.x } / ${param.y } = ${param.x / param.y }<br>

<hr>
	<!-- JSP 자바식 + HTML -->
<%=x %> + <%=y %> = <%=x+y %> <br>
<%=x %> - <%=y %> = <%=x-y %> <br>
<%=x %> * <%=y %> = <%=x*y %> <br>
<%=x %> / <%=y %> = <%=x/y %> <br>
<hr>

	
</body>
</html>
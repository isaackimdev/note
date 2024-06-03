<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name="둘리";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive **</h3>
<!-- 지시자로써 include : 가지고 와서 컴파일 -->
<%@ include file="today.jsp" %>
<h3>** include jsp tag **</h3>
<!-- JSP action태그 -->
<jsp:include page="image.jsp"/>
<p><%=name %></p>
<!-- 컴파일된 것을 가지고 옴 : 충돌없이 결과가 나온, 출력이 된 값이 삽입되어 집니다. -->

</body>
</html>
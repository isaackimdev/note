<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response 내장 객체</title>
</head>
<body>
	<h2>response 내장 객체 - 리다이렉트 예제</h2>
	<script type="text/javascript">
		alert("현재 페이지는 <b>exam3.jsp</b> 페이지 입니다.")
	</script>
<%
	response.sendRedirect("exam3Pro.jsp");
%>

</body>
</html>
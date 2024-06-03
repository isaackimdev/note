<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${su > 0 }">
	<p>수정 완료</p>
</c:if>
<c:if test="${su == 0 }">
	<p>수정 실패</p>
</c:if>
<input type="button" value="목록" onclick="location.href='imageboardList.jsp?pg=${pg}'">
</body>
</html>












<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 완료 확인 페이지</title>
</head>
<body>
<c:if test="${su > 0}">
	<p>글이 저장되었습니다.</p>
</c:if>

<c:if test="${su == 0}">
	<p>글이 저장되지 않았습니다.</p>
</c:if>

</body>
</html>
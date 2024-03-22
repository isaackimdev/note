<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
<c:if test="${su == 0 }">
		<p>회원 정보 수정 실패</p>
</c:if>
<c:if test="${su > 0 }">
		<p>회원 정보 수정 성공</p>
</c:if>
<br>
<a href="../main/index.do">메인 화면</a>

</body>
</html>











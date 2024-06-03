<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score 값 확인하기</title>
</head>
<body>
<c:if test="${insertCount > 0}">
	${score_name } 님의 성적이 정상적으로 등록되셨습니다.
</c:if>
<c:if test="${insertCount == 0}">
	성적 등록에 실패하였습니다.
</c:if>

</body>
</html>
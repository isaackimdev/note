<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과 보여주기</title>
</head>
<body>
 <c:if test="${su > 0 }">
 	<p> 회원가입을 축하드립니다. </p>
 </c:if>
 <c:if test="${su == 0 }">
 	<p> 회원가입에 실패하였습니다.  </p>
 </c:if>
 
</body>
</html>
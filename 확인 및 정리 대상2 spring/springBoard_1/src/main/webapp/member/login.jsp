<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
</script>
</head>
<body>

<c:if test="${name == null }">
	<p>로그인 실패</p>
</c:if>
<c:if test="${name != null }">
	<p>로그인 성공</p>
</c:if>

</body>
</html>












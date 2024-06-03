<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	String apple = (String)request.getAttribute("apple");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForwardResult</title>
</head>
<body>
<%-- 
<p>결과 : <%=apple %></p>
--%>

<!-- default 값으로 request 값을 출력 함. -->
<p>결과 : ${apple }</p>
<p>결과 : ${requestScope.apple }</p>
<p>결과 : ${requestScope['apple'] }</p>
<p>결과 : ${sessionScope.apple }</p>
<p>결과 : ${applicationScope.apple }</p>

</body>
</html>
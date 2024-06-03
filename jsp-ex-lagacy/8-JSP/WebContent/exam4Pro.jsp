<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");					// 일므은 그대로 문자열로 받음
	int age = Integer.parseInt(request.getParameter("age"));	// 나이는 정수로 변환해줌
	if(age >= 19)out.println(name + "님은 성인입니다.<br>");
	else out.println(name+"님은 미성년자입니다.<br>");
%>	<!-- 문자열로 넘어온 데이터 처리  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% if (age >= 20) { %>
			<%=name %> 님의 나이는 20세 이상입니다.
	<% } else if (age < 20) { %>
			<%=name %> 님의 나이는 19세 이하입니다.
	<% } %>	
	
</body>
</html>
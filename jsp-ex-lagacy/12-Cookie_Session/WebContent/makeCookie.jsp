<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cookieName = "id";
	Cookie cookie = new Cookie(cookieName, "hongkd");
	cookie.setMaxAge(60);	// 60초 설정
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
	<h2>쿠키를 생성하는 페이지</h2>
	<p><%=cookieName %> 쿠키가 생성되었습니다.</p>
	<form action="useCookie.jsp" method="post">
	<!-- 요청정보 쿠키정보룰 요청할떄마다 쿠키를 같이 보냄 -->
		<input type="submit" value="생성된 쿠기 화인">
		
		<!-- 쿠키는 여러페이지가 공유하는 데이터 입니다.
		ex) 로그인 정보 (쿠키정보) >> 브라우저에 저장이 됨
		그 쿠키를 >> 서버에 보낸다. setMaxAge로 일정시간이
		지나면 자동으로 로그아웃하게 함. 
		
		서버에서는 쿠키정보를 계속 확인하고, 
		쿠키 확인하여 쿠키를 꺼냅니다.
		
		쿠키 만들고, 사용하고, 확인하는 법		
		
		쿠키는 보안에 약함...
		
		그래서 이것을 보완하기 위해 나온게 [세션]
		
		보안에 관련된 것은 서버에 저장
		보안에 관련되지 않은 것은 쿠키에 저장 > 용량도 적음.
		보안을 위해 데이터를 세션에 저장
		-->
		
		
	</form>
</body> 
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//쿠키 삭제
/*	
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("memName")) {
				cookies[i].setMaxAge(0);	// 쿠키 삭제
				response.addCookie(cookies[i]);
			} else if(cookies[i].getName().equals("memId")) {
				cookies[i].setMaxAge(0);	// 쿠키 삭제
				response.addCookie(cookies[i]);
			}
		}
	}
*/	
	//세션 삭제
	session.removeAttribute("memName");
	session.removeAttribute("memId");
	// 무효화 : 모두 지우기
	session.invalidate();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		alert("로그아웃");
		location.href="../main/index.jsp"
	}
</script>
</head>
<body>
	<p>로그 아웃</p>
</body>
</html>











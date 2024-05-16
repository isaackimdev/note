<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Cookie 삭제
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("id")) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	}
	
	// Session 삭제
	session.removeAttribute("id");
	// 세션 무효화 : 모두 지우기
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout page</title>
<script type="text/javascript">
window.onload = function() {
	alert("logout");
	location.href="../main/index.jsp";
}
</script>
</head>
<body>
	<h2>logout page</h2>
	
	
</body>
</html>
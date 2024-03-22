<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 세션 삭제
	session.removeAttribute("memName");
	session.removeAttribute("memId");
	// 무효화 : 모두 지우기
	session.invalidate();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<script type="text/javascript">
	window.onload = function() {
		alert("로그아웃 되셨습니다.");
		location.href="../main/index.jsp"
	}
</script>
</head>
<body>

</body>
</html>
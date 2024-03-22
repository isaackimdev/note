<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 로그인 됐다고 가정하고, 톰캣서버가 관리하는 클래스 session에 저장~!

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	session.setAttribute("id", id);
	session.setAttribute("passwd", passwd);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 사용</title>
</head>
<body>
<!-- 저장된 것을 바로 꺼내서 확인해 보기. -->
	<h2>세션 속성 설정 및 사용</h2>
	
	<p>id와 passwd 세션 속성을 설정하였습니다.</p>
	<p>id속성의 값은
		<%=(String)session.getAttribute("id") %>이고 <br>
		passwd속성의 값은
		<%=(String)session.getAttribute("passwd") %>입니다.
	</p>
	<!-- 브라우저마다 세션을 따로 관리 함.
	브라우저가 다 닫혀지면 못 읽어 옴 -->
	
</body>
</html>
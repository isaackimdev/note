<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	// DB
	MemberDAO memberDAO = new MemberDAO();
	boolean exist = memberDAO.isExistId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인하기</title>
<script type="text/javascript">
	function checkIdClose() {
		// opener 부모 브라우저를 기준으로 열려 있는애 안에 있는 부모객체,
		// opener 라는 내장 객체 write 부모 브라우저를 관리하는 자바스크립트의 내장객체입니다. writeForm 태그 안에 id 태그 안에 value를 가져 옴 
		opener.writeForm.id.value = '<%=id %>';
		window.close();
		// opener 현재 브라우저 기준으로, 부모브라우저를 말함.
		opener.writeForm.pwd.focus();
	}
</script>
</head>
<body>
<form action="checkId.jsp" method="post"> <!-- 중복체크 창이 있기에 자기 자신을 다시 보낼 것.. -->
	<% if (exist) { %>
		<%=id %>는 사용중입니다. <br><br>
		아이디 <input type="text" name="id">
			<input type="submit" value="중복체크">
	<% } else { %>
		<%=id %>는 사용 가능합니다. <br><br>
		<input type="button" value="사용" onclick="checkIdClose()">
	<% } %>
</form>
</body>
</html>
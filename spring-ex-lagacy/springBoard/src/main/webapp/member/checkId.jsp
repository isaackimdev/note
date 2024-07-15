<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose() {
		opener.writeForm.id.value = '${id}';
		window.close();
		opener.writeForm.pwd.focus();
	}
</script>
</head>
<body>
<form action="checkId" method="post">
<c:if test="${exist}">
	${id }는 사용중입니다. <br><br>
		아이디 <input type="text" name="id">
			  <input type="submit" value="중복 체크">
</c:if>
<c:if test="${!exist}">
	${id }는 사용 가능합니다.<br><br>
		<input type="button" value="사용" onclick="checkIdClose()">

</c:if>

</form>
</body>
</html>












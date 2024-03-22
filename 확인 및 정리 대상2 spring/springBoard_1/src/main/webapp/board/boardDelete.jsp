<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
	 	if(${su > 0}) {
		alert("삭제 성공");
		location.href="boardList?pg=${pg}";
		} else { 
		alert("삭제 실패");
		history.back();
	 	} 
	}
</script>
</head>
<body>

</body>
</html>









<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// int su = (int)request.getAttribute("su");
	// int pg = (int)request.getAttribute("pg");	

	// EL,JSTL을 아직 안쓰기 때문에 데이터(java코드) 와 html 코드가 공존..JSP파일내에
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script type="text/javascript">
	window.onload = function() {
		if(${su} > 0 ) { 
				alert("삭제 성공");
		} else { 
				alert("삭제 실패");
		}
		location.href="boardList.do?pg=${pg}";
	}
</script>
</head>
<body>

</body>
</html>
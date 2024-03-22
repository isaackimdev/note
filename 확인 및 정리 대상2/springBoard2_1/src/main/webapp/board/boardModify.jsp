<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<script type="text/javascript">
	window.onload = function() {
			if(${su > 0}) { 
				alert("작성하신 글을 수정하였습니다.");
			} else { 
				alert("작성하신 글을 수정하지 못하였습니다.");
			} 
		location.href="boardList.do?pg=${pg}"
	}
</script>
</head>
<body>

<c:if test="${su>0 }">
	작성하신 글을 수정하였습니다.
</c:if>

<c:if test="${su==0 }">
	작성하신 글을 수정하지 못하였습니다.
</c:if>

</body>
</html>












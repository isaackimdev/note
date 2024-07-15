<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<script type="text/javascript">
	window.onload = function() {
		if(${updateCount > 0 }) { 
			alert("작성하신 성적을 수정하였습니다.");
		} else {
			alert("작성하신 성적을 수정하지 못하였습니다.");
		}
		location.href="scoreView.do?studNo=${studNo}&pg=${pg}";
	}
</script>
</head>
<body>

<c:if test="${updateCount > 0}">
	<p>작성하신 성적을 수정하였습니다.</p>
</c:if>
<c:if test="${updateCount == 0}">
	<p>작성하신 성적을 수정하지 못하였습니다.</p>
</c:if>

</body>
</html>
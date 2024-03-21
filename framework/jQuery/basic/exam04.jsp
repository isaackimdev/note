<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#hello").html("Hello jQuery!!");
		alert($("#text").html());
	});
</script>
</head>
<body>
<h1 id="hello"></h1>
<p id="text">안녕하세요. 제이쿼리!!</p>
</body>
</html>
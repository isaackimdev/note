<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fadeIn/Out/toggle</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#fade > input:eq(0)").click(function() {
			$("#fade > div").fadeIn(500);
		});		
		$("#fade > input:eq(1)").click(function() {
			$("#fade > div").fadeOut(500);
		});		
		$("#fade > input:eq(2)").click(function() {
			$("#fade > div").fadeToggle(500);
		});		
	});
</script>
</head>
<body>
<h1>fadeIn/fadeOut</h1>
<div id="fade">
	<input type="button" value="보이기">
	<input type="button" value="숨기기">
	<input type="button" value="페이드 토글">
	<div>
		<img alt="" src="img/2.jpg" width="300px" height="200px">
	</div>
</div>
</body>
</html>
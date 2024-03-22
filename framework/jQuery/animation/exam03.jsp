<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>slidUp/Down/Toggle</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#slide > input:eq(0)").click(function() {
			$("#slide > div").slideDown(500);
		});
		$("#slide > input:eq(1)").click(function() {
			$("#slide > div").slideUp(500);
		});
		$("#slide > input:eq(2)").click(function() {
			$("#slide > div").slideToggle(500);
		});
	});
</script>
</head>
<body>
<h1>slideDown/slideUp</h1>
<div id="slide">
	<input type="button" value="보이기">
	<input type="button" value="숨기기">
	<input type="button" value="슬라이드 토글">
	<div>
		<img alt="" src="img/3.jpg" width="300px" height="200px">
	</div>
</div>
</body>
</html>
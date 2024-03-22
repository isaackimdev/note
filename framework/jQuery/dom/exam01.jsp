<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dom</title>
<style type="text/css">
td {width: 100px; height: 100px; text-align: center;}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 태그를 정밀하게 선택하는 연습 dom
		$("td:eq(4)").css("background", "#ffff00");	
		$("td").eq(2).css("background", "#ff0000");
		$("td:eq(4)").next().css("background", "#00ff00");
		$("td:eq(4)").prev().css("background", "#0000ff");
		$("td:eq(4)").parent().css("color", "#ffffff");
		$("td:eq(4)").parent().next().css("color", "#ff0000");
		$("td:eq(4)").parent().prev().css("color", "#0000ff");
		$("td:eq(4)").parent().next().children().css("text-decoration", "underline");		
		$("td:eq(4)").parent().next().children().eq(1).css("font-size", "3em");				
	});
</script>
</head>
<body>
<table border="">
	<tr>
		<td>1번</td>
		<td>2번</td>
		<td>3번</td>
	</tr>
	<tr>
		<td>4번</td>
		<td>5번</td>
		<td>6번</td>
	</tr>
	<tr>
		<td>7번</td>
		<td>8번</td>
		<td>9번</td>
	</tr>
</table>
</body>
</html>
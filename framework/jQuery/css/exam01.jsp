<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			$("#box").css("color", "red");
		});
		$("#btn2").click(function() {
			$("#box").css("color", "green");
		});
		$("#btn3").click(function() {
			$("#box").css("color", "blue");
		});
		$("#btn4").click(function() {
			$("#box").css("background-color", "red");
		});
		$("#btn5").click(function() {
			$("#box").css("background-color", "green");
		});
		$("#btn6").click(function() {
			$("#box").css("background-color", "blue");
		});
		$("#btn7").click(function() {
			$("#box").css("width", "50%");
		});
		$("#btn8").click(function() {
			$("#box").css("width", "auto");
		});
		$("#btn9").click(function() {
			$("#box").addClass("box1");
			$("#box").removeClass("box2");
		});
		$("#btn10").click(function() {
			$("#box").addClass("box2");
			$("#box").removeClass("box1");
		});
		
		
	});
</script>
<style type="text/css">
.box1 {
	margin: 10px auto;
	border: 5px solid #ccc;
	padding: 30px;
	text-align: center;
}
.box2 {
	margin: 10px auto;
	border: 10px solid #ff00ff;
	background-color: #ff0;
	padding: 25px;
	text-align: center;
}
</style>
</head>
<body>
<h1>CSS제어하기</h1>
<div id="box" class="box1"><h1>테스트 영역 입니다.</h1></div>
<input type="button" id="btn1" value="(폰트) red">
<input type="button" id="btn2" value="(폰트) green">
<input type="button" id="btn3" value="(폰트) blue">
<input type="button" id="btn4" value="(배경) red">
<input type="button" id="btn5" value="(배경) green">
<input type="button" id="btn6" value="(배경) blue">
<input type="button" id="btn7" value="width=50%">
<input type="button" id="btn8" value="width=auto">
<input type="button" id="btn9" value="box1 클래스 적용">
<input type="button" id="btn10" value="box2 클래스 적용">
</body>
</html>
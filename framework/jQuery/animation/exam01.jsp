<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show/hide/toggle</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/** 첫 번째 input 버튼을 누른 경우 */
		// :eq(n)은 특정 셀렉터가 여러개의 복숫 요소를 지정할 경우,
		// 그 중에서 하나만을 지저하는 jQuery 전용 셀렉터이다.
		// "0"부터 카운트 된다.
		$("#sh > input:eq(0)").click(function() {
			$("#sh > div").show(500);
		});
		$("#sh > input:eq(1)").click(function() {
			$("#sh > div").hide(500);
		});
		$("#sh > input:eq(2)").click(function() {
			$("#sh > div").toggle(500);
		});
	});
</script>
</head>
<body>
<h1>show/hide</h1>
<div id="sh">
	<input type="button" value="보이기">
	<input type="button" value="숨기기">
	<input type="button" value="토글">
	<div>
		<img alt="" src="img/1.jpg" width="300px" height="200px">
	</div>
</div>
<p>테스트</p>
</body>
</html>
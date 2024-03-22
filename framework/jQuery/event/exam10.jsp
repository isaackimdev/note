<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/event.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("form[name='form1']").submit(function() {
			if(!confirm("정말 저장하시겠습니까?")) {
				return false;
			}
		});
		
		$("input[type='reset']").click(function() {
			if(!confirm("정말 입력을 취소하시겠습니까?")) {
				return false;
			}
		});
	});
</script>
</head>
<body>
<h1>회원가입</h1>
<form action="form_ok.jsp" name="form1">
	<div id="input">
		<h3>당신의 이름은 무엇입니까?</h3>
		<input type="text" name="name"><br>
		<input type="submit" value="저장하기" class="myButton">
		<input type="reset" value="다시작성" class="myButton">		
	</div>
</form>
</body>
</html>
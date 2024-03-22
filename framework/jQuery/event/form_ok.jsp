<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/event.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h1>회원가입</h1>
<div id="input">
	<h2>${param.name }이 저장되었습니다.</h2>
	<input type="button" id="backBtn" value="이전 페이지로 이동"
		class="myButton" onclick="history.back()">
</div>

</body>
</html>
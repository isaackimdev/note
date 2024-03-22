<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/event.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var index = 1;
		$("img").click(function() {
			// index 가 1~3을 순환하는 계산
			index = (index % 3) + 1;
			// 이미지 파일의 변경
			$(this).attr("src", "img/" + index + ".jpg");
		});
	});
</script>
</head>
<body>
<h1>속성 제어</h1>
<p>클릭하세요</p>
<img src="img/1.jpg" alt="이미지">
</body>
</html>












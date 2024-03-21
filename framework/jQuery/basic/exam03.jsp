<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {	// $ 객체 : jQuery의 모든 기능을 받는다.
		var h1=$("#hello");
		h1.html("Hello jQuery!!");
	});
</script>
</head>
<body>
<h1 id="hello"></h1>
</body>
</html>
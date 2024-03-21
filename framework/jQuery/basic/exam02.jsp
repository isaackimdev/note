<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function hello($) {
		var h1 = $(".hello");	// . 은 class | #은 id
		h1.html("Hello jQuery!! 안녕제이쿼리");
	}
	jQuery(hello);
</script>
</head>
<body>
<h1 id="hello" class="hello"></h1>
</body>
</html>
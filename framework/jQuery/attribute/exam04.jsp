<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("img[src='img/jquery.jpg']").hover(function() {
			$(this).attr("src", "img/jquery_on.jpg");
		}, function() {
			$(this).attr("src", "img/jquery.jpg");
		});
			
		$("img[src='img/javascript.jpg']").hover(function() {
			$(this).attr("src", "img/javascript_on.jpg");
		}, function() {
			$(this).attr("src", "img/javascript.jpg");
		});
		
		$("img[src='img/css.jpg']").hover(function() {
			$(this).attr("src", "img/css_on.jpg");
		}, function() {
			$(this).attr("src", "img/css.jpg");
		});
			
		$("img[src='img/html.jpg']").hover(function() {
			$(this).attr("src", "img/html_on.jpg");
		}, function() {
			$(this).attr("src", "img/html.jpg");
		});
	});
</script>
<style type="text/css">
/** 목록정의 요소의 여백 제거, 넓이지정, 기호 제거 */
ul {
	padding: 0; margin: 0; width:670px; list-style: none;
}
/** 목록의 가로 배치 */
li {
	float: left;
}
/** float 속성 해제 */
ul:after {
	content: ''; display: block;
	float: none; clear: both;
}
/** 이미지 테두리 제거 */
img {
	border: none;
}
</style>
</head>
<body>
<ul>
	<li><a href="#"><img alt="jQuery" src="img/jquery.jpg"></a></li>
	<li><a href="#"><img alt="javascript" src="img/javascript.jpg"></a></li>
	<li><a href="#"><img alt="CSS" src="img/css.jpg"></a></li>
	<li><a href="#"><img alt="HTML" src="img/html.jpg"></a></li>
</ul>

</body>
</html>
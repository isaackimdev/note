<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parents/find</title>
<style type="text/css">
div {width:480px; height: 300px; padding-top: 20px; background-size: 100% 100%;}
ul {padding:10px 20px; background-color: rgba(255, 255, 255, 0.6);}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 링크가 클릭된 경우
		$(".item > a").click(function() {
			// index() 함수는 요소의 부모 태그 안에서 몇 번째 항목인지를 검사한다.
			// 여기서는 <a>의 parent()의 index() 이므로 <li>태그가 그 부모인
			// <ul>태그 안에서 몇 번째 요소인지 검사한다. --> 0~2 사이의 값
			var index = $(this).parent().index();
			// 표시할 이미지의 경로를 배열로 지정
			var image = ['img/1.jpg', 'img/2.jpg', 'img/3.jpg'];
			// 클릭된 링크의 조상들 중에서 <div> 태그를 검색하여 CSS 배경이미지 설정
			$(this).parents("div").css({
				"background-image" : "url('"+ image[index] + "')"
			});
			// href 속성을 무효화 시킴
			return false;
		});
	});
</script>

</head>
<body>
<div>
	<ul id="menu">
		<li class="item">
			<a href="#">img/1.jpg</a>
		</li>
		<li class="item">
			<a href="#">img/2.jpg</a>
		</li>
		<li class="item">
			<a href="#">img/3.jpg</a>
		</li>
		
	</ul>
</div>
</body>
</html>
























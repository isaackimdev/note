<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 이미지+링크를 클릭한 경우
		$("a.img").click(function() {
			// 배경 레이러를 화면에 표시한다.
			$("#layer1").fadeIn(350);
			// 이미지 레이어를 화면에 표시한다.
			$("#layer2").fadeIn(350);
			// 링크가 갖는 href 속성의 주소를 <img>태그에 설정하여
			// 이미지 레이어에 출력한다.
			$("#layer2").html("<img src='" + $(this).attr("href") + "'>");
			// 링크의 페이지 이동 중단.
			return false;
		});
		
		// (화면에 표시된) 배경 레이어를 클릭한 경우
		$("#layer1").click(function() {
			// 배경 레이어의 숨김
			$(this).fadeOut(350);
			// 이미지 레이어의 숨김
			$("#layer2").fadeOut(300);
		});
	});
</script>
<style type="text/css">
	img {width:200px; height:120px;}
	ul {width:810; marging:auto; list-style: none;}
	ul li {float:left;}	/* 가로 배열 */
	ul li img {border:0; margin:2px;} /* 이미지에 대한 테두리 제거 및 여백 지정*/
	/** 배경 레이어의 위치, 크기, 투명도 지정 > 기본적으로 표시되지 않도록 설정 */
	div#layer1 {
		display: none; position:fixed; left: 0; top: 0;
		height: 100%; width: 100%; background: black;
		fliter: alpha(opacity=60); opacity: 0.60;
	}
	/** 이미지가 표현될 레이어를 화면 중앙에 배치
		> 기본적으로 표시되지 않도록 설정 */
	div#layer2 {
		display:none; position:fixed; left:20%; top:50%;
		margin-top: -100px; margin-left: -325;
		border:2px solid red;
	}
</style>
</head>
<body>
<!-- 화면에 표시될 원본 보기 영역  - 기본적으로 숨겨진 상태이다. -->
<div id="layer1"></div>
<div id="layer2"></div>
<!-- 이미지 목록 -->
<ul>
	<li><a href="imgs/1.png" class="img">
		<img src="imgs/1.png">
	</a><li>
	<li><a href="imgs/2.png" class="img">
		<img src="imgs/2.png">
	</a><li>
	<li><a href="imgs/3.png" class="img">
		<img src="imgs/3.png">
	</a><li>
	<li><a href="imgs/4.png" class="img">
		<img src="imgs/4.png">
	</a><li>
	<li><a href="imgs/5.png" class="img">
		<img src="imgs/5.png">
	</a><li>
	<li><a href="imgs/6.png" class="img">
		<img src="imgs/6.png">
	</a><li>
	<li><a href="imgs/7.png" class="img">
		<img src="imgs/7.png">
	</a><li>
	<li><a href="imgs/8.png" class="img">
		<img src="imgs/8.png">
	</a><li>
</ul>

</body>
</html>
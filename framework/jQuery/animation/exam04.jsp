<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageView</title>
<style type="text/css">
/** 목록 박스의 넓이 지정 및 중앙 배치, 마커제거 */
ul {width: 700px; margin: auto; list-style: none;}
/** 각 항목에 대한 가로 배열 */
ul li {float: left;}
/** 이미지에 대한 테두리 제거 및 여백 지정 */
ul li img {border: 0; margin: 10px;}
/** 배경 레이어의 위치 , 크기,
	투명도 지정 > 기본적으로 표시되지 않도록 설정 */
div#glayLayer {
	display: none; position: fixed; left: 0; top: 0;
	height: 100%; width: 100%; background: black;
	filter: alpha(opacity=60); opacity: 0.60;
}
/** 이미지가 표현될 레이어를 화면 중앙에 배치
	> 기본적으로 표시되지 않도록 설정 */
#overLayer {
	display: none; position: fixed; left: 20%; top: 50%;
	margin-top: -244px; margin-left: -325;
}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 링크를 클릭한 경우
		$("a.modal").click(function() {
			// 배경 레이어를 화면에 표시한다.
			$("#glayLayer").fadeIn(300);
			// 이미지 레이어를 화면에 표시한다.
			$("#overLayer").fadeIn(300);
			// 링크가 갖는 href 속성의 주소를 <img> 태그에 설정하여
			// 이미지 레이어를 출력한다.
			$("#overLayer").html("<img src='" + $(this).attr("href") + "'>");
			// 링크의 페이지 이동 중단.
			return false;
		});
		
		// (화면에 표시된) 배경 레이어를 클릭한 경우
		$("#glayLayer").click(function() {
			// 배경 레이어의 숨김
			$(this).fadeOut(300);
			// 이미지 레이어의 숨김
			$("#overLayer").fadeOut(200);
		});
	});
</script>
</head>
<body>
<!-- 화면에 표시될 원본 보기 영역 - 기본적으로 숨겨진 상태이다. -->
<div id="glayLayer"></div><div id="overLayer"></div>
<!-- 이미지 목록 -->
<ul>
	<li><a href="img/photo1.jpg" class="modal">
		<img alt="샹드리아" src="img/photo1_thum.jpg">
	</a></li>
	<li><a href="img/photo2.jpg" class="modal">
		<img alt="장비" src="img/photo2_thum.jpg">
	</a></li>
	<li><a href="img/photo3.jpg" class="modal">
		<img alt="바다" src="img/photo3_thum.jpg">
	</a></li>
	<li><a href="img/photo4.jpg" class="modal">
		<img alt="문" src="img/photo4_thum.jpg">
	</a></li>
	<li><a href="img/photo5.jpg" class="modal">
		<img alt="바다" src="img/photo5_thum.jpg">
	</a></li>
	<li><a href="img/photo6.jpg" class="modal">
		<img alt="꽃" src="img/photo6_thum.jpg">
	</a></li>
	<li><a href="img/photo7.jpg" class="modal">
		<img alt="하늘" src="img/photo7_thum.jpg">
	</a></li>
	<li><a href="img/photo8.jpg" class="modal">
		<img alt="건물" src="img/photo8_thum.jpg">
	</a></li>
</ul>
</body>
</html>
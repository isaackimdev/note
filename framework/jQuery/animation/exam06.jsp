<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box {
	background: #98BF21;
	height: 100px;
	width: 100px;
	position: absolute;
	left:0;
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button:eq(0)").click(function() {
			// 새롭게 내용을 코딩
			$("#animation-area").html("<div id='box'></div>");
		});
		/** 좌측으로부터 250px 만큼 div 값을 이동 */
		$("button:eq(1)").click(function() {
			// CSS 속성은 JSON 형식으로 표현된다.
			$("#box").animate(
				{
					'left' : '250px'	
				},
				1000, 'swing',
				function() {
					alert("애니메이션이 종료되었습니다.");		
				}
			);
		});
		/** 좌측으로부터 250px 이동하고, 높이와 넓이를 150px에 하라! */
		$("button:eq(2)").click(function() {
			// CSS 속성은 JSON 형식으로 표현된다.
			$("div").animate(
				{
					'left' : '250px',
					height : '150px',
					width : '150px'
				}
			);
		});
		/** 좌측으로부터 50px 이동하고, 높이와 넓이를 50px씩 크게 해라. */
		$("button:eq(3)").click(function() {
			// CSS 속성은 JSON 형식으로 표현된다.
			$("div").animate(
				{
					'left' : '+=50px',
					height : '+=50px',
					width : '+=50px'
				}, 300
			);
		});
		/** 애니메이션의 연속적 호출 */
		$("button:eq(4)").click(function() {
			// CSS 속성은 JSON 형식으로 표현된다.
			$("div#box").animate({height : '300px'}, 1000);
			$("div#box").animate({width : '300px'}, 500);
			$("div#box").animate({height : '100px'}, 1000);
			$("div#box").animate({width : '100px'}, 500);
		});
	});
</script>
</head>
<body>
<h1>Animate</h1>
<button>Reset</button>
<button>Ani1</button>
<button>Ani2</button>
<button>Ani3</button>
<button>Ani4</button>
<div id="animation-area">
	<div id="box"></div>
</div>
</body>
</html>
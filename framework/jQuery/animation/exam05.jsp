<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>endfunction</title>
<style type="text/css">
	/** 목록정의 태그의 초기화 및 박스 왼쪽 배치 (float) */
	#thumb {
		padding: 0; margin: 0;
		list-style: none;
		width: 100px;
		float: left;
	}
	/** 목록의 개별 항목에 대한 여백 처리 */
	#thumb li {
		padding: 5px 10px;
	}
	/** 썸네일 이미지 크기 지정 */
	#thumb img {
		width: 80px; height: 80px;
	}
	/** 큰 이미지 영역 크기 지정 및 왼쪽 배치 (float) */
	#view {
		padding: 5px 0; width: 360px; height: 270px;
		float: left;
	}
	/** 이미지의 크기 지정 */
	#view img {
		width:100%; height: 100%;
	}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/** 첫 번째 링크를 클릭한 경우 */
		$("a.item:eq(0)").click(function() {
			// 링크의 주소에 지정된 href 속상값 획득
			var image = $(this).attr("href");
			// 이미지 영역을 0.5초간 숨기고...
			$("#view").hide(500, function() {
				// 이미지가 사라진 다음에는
				// 이미지의 경로를 클릭한 링크의 href 속성값으로 대치
				$("#view img").attr("src", image);
				// 다시 현재 요소를 화면에 보여준다.
				$(this).show(300);
			});
			
			return false;
		});
		
		/** 아래는 같은 방법으로 애니메이션의 종류만 fade와 slide로 변경한 코드 */
		/** 두 번째 링크를 클릭한 경우 */
		$("a.item:eq(1)").click(function() {
			var image = $(this).attr("href");
			
			$("#view").fadeOut(500, function() {
				$("#view img").attr("src", image);
				$(this).fadeIn(300);
			});
			
			return false;
		});
		/** 세 번째 링크를 클릭한 경우 */
		$("a.item:eq(2)").click(function() {
			var image = $(this).attr("href");

			$("#view").slideUp(500, function() {
				$("#view img").attr("src", image);
				$(this).slideDown(300);
			});
			
			return false;
		});
		
	});
</script>
</head>
<body>
<!-- 썸네일 이미지 영역 -->
<ul id="thumb">
	<li>
		<a href="img/1.jpg" class="item"><img src="img/1.jpg"></a>
	</li>
	<li>
		<a href="img/2.jpg" class="item"><img src="img/2.jpg"></a>
	</li>
	<li>
		<a href="img/3.jpg" class="item"><img src="img/3.jpg"></a>
	</li>
</ul>
<!-- 큰 이미지 영역 -->
<div id="view"><img alt="" src="img/1.jpg"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/** 목록의 기본 속성 초기화 */
ul {margin:0; padding:0; list-style: none;}
/** 목록 아이템의 가로 배치 및 크기와 배경이미지 지정 */
ul.menu li {
	float: left; width: 179px; height: 48px;
	background: url("img/btn.png");
}
/** 메뉴의 링크에 대한 크기 지정 및 글자 꾸미기 */
ul.menu li a {
	display: block;width: 100%; height: 100%;
	line-height: 48px; text-align: center;
	font-weight: bold; color: #CFDFB5;
	text-decoration: none;
}
/** 마우스가 올라간 링크에 대한 배경이미지 변경 */
ul.menu li a:hover {
	background: url("img/btn_over.png");
}
/** 가로 배치에 사용된 float 속성 해제 */
ul.menu:after {
	content: ''; display: block; clear:both; float: none;
}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 모든 서브 메뉴 숨기기
		$("ul.menu > li > .sub").hide();
		// 메뉴에 마우스가 위치할 때
		$("ul.menu > li").hover(function() {
			// 마우스가 올라간 현재 요소의 하위요소 중에서
			// ".sub" 클래스를 갖는 요소를 찾는다.
			// 찾아낸 요소에게 slideDown 애니메이션을 적용한다.
			$(this).find(".sub").slideDown(100);
		}, function() {
			//모든 서브 메뉴에 대하여, 숨김처리
			$("ul.menu > li > .sub").slideUp(100);
		});
	});
</script>

</head>
<body>
<ul class="menu">
	<li>
		<a href="#">메뉴A</a>
		<ul class="sub">
			<li><a href="#">서브메뉴A</a></li>
			<li><a href="#">서브메뉴A</a></li>
			<li><a href="#">서브메뉴A</a></li>
		</ul>
	</li>
	<li>
		<a href="#">메뉴B</a>
		<ul class="sub">
			<li><a href="#">서브메뉴B</a></li>
			<li><a href="#">서브메뉴B</a></li>
			<li><a href="#">서브메뉴B</a></li>
		</ul>
	</li>
	<li>
		<a href="#">메뉴C</a>
		<ul class="sub">
			<li><a href="#">서브메뉴C</a></li>
			<li><a href="#">서브메뉴C</a></li>
			<li><a href="#">서브메뉴C</a></li>
		</ul>
	</li>
</ul>
</body>
</html>
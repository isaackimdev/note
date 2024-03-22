<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tab</title>
<style type="text/css">
/** 전체 요소의 기본 여백 초기화 */
* {
	padding: 0; margin: 0;
}
/** 탭 박스의 기본 크기와 중앙 정렬 및 상하 여백 */
#container {
	width: 500px; margin: 20px auto;
}
/** 탭 버튼의 초기화 및 레이어 띄우기
	> 내용영역과 1px 겹쳐져야 한다. */
ul.tab {
	list-style: none; position: relative; z-index: 100;
}
/** 개별 버튼에 대한 기본 크기와 가로 정렬 */
ul.tab li {
	width: 100px; height: 40px; float: left;
}
/** float 속성 해제 처리 */
ul:after {
	content: ''; display: block;
	float: none; clear: both;
}
/** 탭 버튼의 기본 배경 처리와 글자 형태 처리 */
ul.tab li a {
	background: url("img/tab.jpg");
	display: block; color: #222; line-height: 40px;
	text-align: center; text-decoration: none;
}
/** 현재 활성 탭의 배경 이미지 별도 처리 */
ul.tab li a.selected {
	background: url("img/tab_selected.jpg");
}
/** 내용영역의 테두리처리 및 상단으로 -1px 이동시킴.
	버튼 영역과 1px 겹치게 처리해서 활성탭이 뚫려 있는
	효과 연출 */
p.panel {
	border: 1px solid #9FB7D4;
	position:relative;
	top: -1px;
	padding: 10px;
	margin: 0;
}

</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/** 페이지 열릴 때, 기본 탭의 내용 출력 처리 */
		// panel이라는 클래스를 갖는 p태그 안에,
		// 탭 버튼 안의 selected 클래스가 적용된 링크의 href 속성이 가리키는
		// URL값을 load 함수에게 전달한다.
		// --> 즉, 링크가 가리키는 파일을 읽어서 <p>안에 출력한다.
		$("p.panel").load($("ul.tab li a.selected").attr("href"));	// load()는 그 파일을 읽어와 로드한다.
		/**탭 버튼의 클릭 처리 */
		$("ul.tab li a").click(function() {
			// 클릭된 요소를 제외한 나머지에게 selected 클래스 제거
			// --> 배경이미지 원상복구됨
			$("ul.tab li a").not(this).removeClass("selected");
			// 클릭된 요소에게 selected 클래스 적용 --> 배경이미지 변경됨
			$(this).addClass("selected");
			// 클릭된 요소의 href 속성값이 가리키는 파일을 읽어서 <p>에 출력함
			$("p.panel").load($(this).attr("href"));
			// a 태그 페이지 이동 방지
			return false;	// return false는  a태그 href 속성을 무효화 시킴
		});
	});
</script>
</head>
<body>
<div id="container">
	<!-- 탭 버튼 영역 -->
	<ul class="tab">
		<li><a href="txt/html5.txt" class="selected">HTML5</a></li>
		<li><a href="txt/jquery.txt">jQuery</a></li>
		<li><a href="txt/bootstrap.txt">Bootstrap</a></li>
	</ul>
	<!-- 내용영역 -->
	<p class="panel"></p>
</div>
	

</body>
</html>
























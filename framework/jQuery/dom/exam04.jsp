<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>collapsible</title>
<style type="text/css">
	/** 배경 지정 */
	body { background: #252422;}
	/** 목록 스타일 초기화 및 중앙 배치, 가로 폭 지정 */
	ul {
		padding: 0; margin: 50px auto;
		list-style: none; width: 800px;
	}
	/** 제목 영역의 초기화 처리 */
	.title {padding: 0; margin: 0; }
	/** 링크의 클릭 영역 확대 및 배경 및 폰트 처리 */
	.title > a {
		display: block;
		padding-top: 12px;
		font-size: 14px;
		text-indent: 12px;
		text-decoration: none;
		font-weight: bold;
		color: white;
		height: 23px;
		background: url("img/background.jpg");
	}
	/** 현재 활성화된 요소에 적용할 배경이미지 지정 */
	.selected {
		background: url("img/background-selected.jpg") !important;
		
	}
	/** 내용영역 */
	.content {
		margin: 0;
		background: #D4D0C7;
		padding: 10px;
		height: 200px;
		overflow-y:auto;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/** 초기화 처리 */
		// 첫 번째 항목이 펼쳐져 있도록 처리한다.
		// 탭의 내용은 첫 번째 항목 안의 <a>태그가 가리키는
		// txt 파일을 읽어와서 출력시킨다.
		$(".collapsible:eq(0) > .content")
		.load($(".collapsible:eq(0) .title a").attr("href"));
		// 첫 번째 항목의 <a>에게 selected 클래스를 적용하여 준다.
		$(".collapsible:eq(0) a").addClass("selected");
		// 첫 번째 항목 이외의 나머지 항목들 안에 있는 content를 숨긴다.
		$(".collapsible").not(":eq(0)").find(".content").hide();
		
		/** 링크에 대한 클릭 이벤트 처리 */
		$(".collapsible .title a").click(function() {
			// 클릭된 자기 자신은 selected 클래스를 적용한다.
			// 만약 적용된 상태라면 제거한다.
			$(this).toggleClass("selected");
			// 클릭된 나 자신을 제외한 나머지 링크들은
			// selected 클래스를 무조건 삭제한다.
			$(".collapsible .title a").not(this).removeClass("selected");
			// 펼칠 대상을 검색
			var target = $(this).parents(".collapsible").find(".content");
			// 나머지 대상을 검색
			var other = 
				$(".collapsible .title a").not(this).parents(".collapsible")
				.find(".content");
			// 애니메이션으로 열고 닫기 처리
			target.slideToggle(300);
			other.slideUp(300);
			// 현재 클릭된 항목에 대한 내용이 열려진 상태라면,
			// 내용을 load() 함수로 불러와서 출력
			if(target.css("display") != "none") {
				target.load($(this).attr("href"));
			}
			// 링크의 페이지 이동 중지
			return false;
		});i
	});
</script>

</head>
<body>
<ul>
	<li class="collapsible">
		<h2 class="title"><a href="txt/html5.txt">HTML5</a></h2>
		<p class="content"></p>
	</li>
	<li class="collapsible">
		<h2 class="title"><a href="txt/jquery.txt">jQuery</a></h2>
		<p class="content"></p>
	</li>
	<li class="collapsible">
		<h2 class="title"><a href="txt/bootstrap.txt">Bootstrap</a></h2>
		<p class="content"></p>
	</li>
</ul>
</body>
</html>
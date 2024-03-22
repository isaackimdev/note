<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/news.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="plugins/xdomain/jquery.xdomainajax.js"></script>
<script type="text/javascript">
	/** 구글 뉴스 데이터를 불러와서 화면에 출력하는 함수 */
	function getNewsList(topic) {
		// 접속할 주소
		var url = "https://news.google.com/news/feeds";
		// 구글에서 요구하는 파라미터
		var data = {
			"pz":1,
			"cf":"all",
			"ned":"kr",
			"hl": "ko",
			"topic": topic,	
			"output": "rss"
		};
		// get방식으로 Ajax 크로스 도메인 요청
		$.get(url, data, function(data) {
			// XML 본문 추출
			var xml = data.responseText;
			// XML을 jQuery객체로 변환한 뒤, item태그 단위로 반복
			$(xml).find("item").each(function() {
				// 각 태그 안에서 텍스트 추출
				// .replace(...) 은 HTML태그를 제거하는 기능(정규표현식)
				var title = 
					$(this).find("title").text().replace(/(<([^>]+)>)/ig, "");
				var description = 
					$(this).find("description").text().replace(/(<([^>]+)>)/ig, "");
				var pubDate = $(this).find("pubDate").text();
				// 요소의 동적 생성
				var li = $("<li>");
				var span1 = $("<span>").addClass("text");
				var span2 = $("<span>").addClass("title").html(title);
				var span3 = $("<span>").addClass("pubDate").html(pubDate);
				var span4 = $("<span>").addClass("desc").html(description);
				// 조립
				var item = li.append(span1.append(span2).append(span3).append(span4));
				// 출력
				$("#list").append(item);
			});
		});
	}
	
	$(function() {
		// 페이지가 열리면 기본적으로 현재 선택되어 있는 항목에 대한 로딩
		getNewsList($("#topic > option:selected").val());
		// 드롭다운의 선택항목이 변경된 경우...
		$("#topic").change(function() {
			// 이전 검색결과 삭제
			$("#list").empty();
			// 선택항목의 value값을 획득해서 ajax 연동을 구현한 함수에게 전달
			getNewsList($(this).find("option:selected").val());
		});
	});
</script>
</head>
<body>
<h1 class="title">구글 뉴스 연동</h1>
<div class="exec">
	<form action="" name="form1">
		<fieldset>
			<legend for="topic">뉴스분야 선택</legend>
			<select name="topic" id="topic">
				<option value="">주요뉴스</option>
				<option value="p">정치</option>
				<option value="b">경제</option>
				<option value="y">사회</option>
				<option value="l">문화/생활</option>
				<option value="w">국제</option>
				<option value="t">과학기술</option>
				<option value="e">연예</option>
				<option value="s">스포츠</option>
			</select>
		</fieldset>
	</form>
</div>
<!-- 데이터 출력될 곳 -->
<ul id="list"></ul>
</body>
</html>













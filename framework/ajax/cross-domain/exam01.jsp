<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!-- plugin 참조 -->
<script type="text/javascript" src="plugins/xdomain/jquery.xdomainajax.js"></script>

<style type="text/css">
	/** 목록의 항목간 구분선 */
	ul li {border-bottom: 1px dotted #7BAEB5;}
	ul li:first-child {border-top: 1px dotted #7BAEB5;}
	/** 각 항목의 크기와 색상 */
	ul li {
		display: block; width: auto;
		padding: 13px 10px 10px 10px;
		color: #222;	text-decoration: none;
	}
</style>

<script type="text/javascript">
	$(function() {
		// 페이지 열리면 데이터 로드
		var url = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		$.get(url, {}, function(data) {
			// 읽은 결과의 responseText 속성을 사용하여 XML본문을 얻는다.
			var xml_text = data.responseText;
			// XML 본문을 jQuery 객체로 변환
			var xml = $(xml_text);
			// weather 태그에서 년/월/일/시 추출
			var weather = xml.find("weather");
			var yy = weather.attr("year");
			var mm = weather.attr("month");
			var dd = weather.attr("day");
			var hh = weather.attr("hour");
			// 시간 출력
			$("#date").html("(" + yy + "년" + mm + "월" + dd + "일" + hh + "시)");
			// local 태그의 수 만큼 반복
			xml.find("local").each(function() {
				// 개별 요소에서 도시 이름과 설명, 기온을 추출
				var city = $(this).text();
				var desc = $(this).attr("desc");
				var ta = $(this).attr("ta");
				// 동적요소를 생성하여 <ul>태그 안에 출력
				var li = $("<li>").html("[" + city + "] "
						+ desc + " / 현재 기온 : " + ta);
				$("#list").append(li);
			});
		});
	});
</script>
</head>
<body>
<h1 class="title">전국 날씨 정보<span id="date"></span><!-- 날짜 출력될 곳 --></h1>
<!-- 데이터 출력될 곳 -->
<ul id="list"></ul>
</body>
</html>
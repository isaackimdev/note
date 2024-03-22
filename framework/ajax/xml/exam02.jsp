<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml(2)</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#mybtn").click(function() {
			$.ajax({
				url: "ajax/xml/xml04.xml",
				type: "get",
				dataType: "xml",
				cache: false,
				timeout: 30000,
				success: function(xml) {
					// 반복되는 태그 단위를 찾아서 each() 함수 사용
					$(xml).find("subject").each(function() {
						// 각 개별 요소에 속해 있는 텍스트 데이터 추출
						var title = $(this).find("title").text();
						var time = $(this).find("time").text();
						var teacher = $(this).find("teacher").text();	
						// 추출된 데이터를 화면에 출력하기 위한 HTML요소를 동적으로 생성
						var div = $("<div>");
						var p1 = $("<p>").html(title);
						var p2 = $("<p>").html(time);
						var p3 = $("<p>").html(teacher);
						// 메서드 체인을 사용한 동적 요소의 결합
						div.append(p1).append(p2).append(p3);
						// 화면에 표시
						$("#result").append(div);
						$("#result").append("<hr>");
					});
				},
				error: function(xhr, textStatus, errorThrown) {
					$("div#result").html("<div>" + textStatus
							+ "(HTTP-" + xhr.status + " / "
							+ errorThrown + ")</div>");	
				}
			});
		});
	});
</script>
</head>
<body>
<h1 class="title">$.ajax() 함수를 사용한 XML데이터 읽기 (2)</h1>
<div class="exec">
	<input type="button" value="xml데이터 가져오기" id="mybtn">
</div>
<div class="console" id="result"></div>
</body>
</html>
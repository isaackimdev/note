<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="plugins/xdomain/jquery.xdomainajax.js"></script>
<script type="text/javascript">
	$(function() {
		$("#mybtn").click(function() {
			$.ajax({
				url: "ajax/json/json05.json",
				type: "get",
				dataType : "json",
				cache: false,
				timeout: 30000,
				success : function(json) {
					// 배열까지 접근한다.
					var subject = json.school.subject;
					// 배열의 길이만큼 반복문 처리한다.
					for(var i=0; i<subject.length; i++) {
						// 반복처리 안에서 i번째 요소는 JSON데이터 자체이다.
						var title = subject[i].title;
						var time = subject[i].time;
						var teacher = subject[i].teacher;
						/** 결과를 출력하기 위한 동적 요소의 생성 */
						var ul = $("<ul>");
						var li1 = $("<li>").html(title);
						var li2 = $("<li>").html(time);
						var li3 = $("<li>").html(teacher);
						// 조립
						ul.append(li1).append(li2).append(li3);
						// 출력
						$("#result").append(ul);
						$("#result").append("<hr>");
						
					}
				},
				error : function(xhr, textStatus, errorThrown) {
					$("div#result").html("<div>" + textStatus
							+ "(HTTP-" + xhr.status + " / "
							+ errorThrown + ")</div>" );
				}
			});
		});
	});
</script>
</head>
<body>
<h1 class="title">$.ajax() 함수를 사용한 JSON데이터 읽기 (2)</h1>
<div class="exec">
	<input type="button" value="JSON데이터 가져오기" id="mybtn">
</div>
<!-- 데이터 출력될 곳 -->
<div class="console" id="result"></div>
</body>
</html>
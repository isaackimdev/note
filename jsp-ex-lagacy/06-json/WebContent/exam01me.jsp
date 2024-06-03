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
			$.ajax( {
				url : "ajax/json/json04.json",
				type: "get",
				dataType: "json",
				cache:false,
				success:function(json) {	// 자바스킓트 안에서 작업하기 때문????
					// 파라미터로 전달되는 객체는 JSON 자체이다.
					var title = json.school.subject.title;
					var time = json.school.subject.time;
					var teacher = json.school.subject.teacher;
					/** 요소의 동적 생성 및 데이터 출력 구현 */
					var ul = $("<ul>");
					var li1 = $("<li>").html(title);
					var li2 = $("<li>").html(time);
					var li3 = $("<li>").html(teacher);
					$("#result").append(ul.append(li1).append(li2).append(li3));
					
				},
				error: function(xhr, textStatus, errorThrown) {
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
<h1 class="title">$.ajax() 함수를 사용한 JSON데이터 읽기 (1)</h1>
<div class="exec">
	<input type="button" value="JSON데이터 가져오기" id="mybtn">
</div>
<!-- 데이터 출력될 곳 -->
<div class="console" id="result"></div>
</body>
</html>












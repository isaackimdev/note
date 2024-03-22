<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create</title>
<style type="text/css">

</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 추가된 동적 요소의 수를 카운트 하기 위한 전역변수
		var i = 1;
		var h3 = $("<h3>").html("오늘은 화요일!!!");
		$("body").append(h3);
		
		// 첫번째 버튼이 눌렸을 때
		$("input:eq(0)").click(function() {
			// 새로운 요소의 생성
			// li 태그에 컬러 레드를 추가 시킴					// 태그내에 출력할 글자
			var li1 = $("<li>").css("color", "red").html("추가항목" + (i++));
			var li2 = $("<li>").css("color", "green").html("추가항목" + (i++));
			var li3 = $("<li>").css("color", "blue").html("추가항목" + (i++));			
			var li4 = $("<li>").html("TEST");
			// 새로 생성된 요소에 대한 이벤트 추가
			// remove() 함수는 해당 요소를 삭제하는 기능임
			li1.click(function(){
				$(this).remove();
			});
			li2.click(function(){
				$(this).remove();
			});
			li3.click(function(){
				$(this).remove();
			});
			// A.append(B) --> A에 B를 추가하다.
			// B.appendTo(A)) --> B를 A에 추가하다.
			li1.appendTo($("ul"));
			$("ul").append(li2);
			$("ul").append(li3);
			$("ul").append(li4);
		});
		
		// 특정 태그 삭제
		$("input:eq(1)").click(function() {
			$("ul").empty();
		});
	
	});
</script>

</head>
<body>
<input type="button" value="추가">
<input type="button" value="삭제">
<!-- 동적으로 요소가 추가될 태그 -->
<ul>
	<li>추가항목1</li>
	<li>추가항목2</li>
	<li>추가항목3</li>
</ul>

</body>
</html>
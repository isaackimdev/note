<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkall</title>
<link rel="stylesheet" type="text/css" href="css/event.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// #all_check 요소의 상태가 변한 경우
		$("#all_check").change(function() {
			// 스스로의 체크 상태 판별
			var is_check = $(this).is(":checked");
			// .hobby_check 요소들의 체크 상태 일괄 변경
			// 체크박스의 선택은 HTML 태그의 checked 속성으로 추가할 수 있다.
			// 이 속성은 이름만 지정하고 별도의 값이 없는 형태이기 때문에,
			// attr() 함수가 아닌 prop 함수를 사용한다.
			$(".hobby_check").prop("checked", is_check);
		});
	});
</script>
</head>
<body>
<h1>전체 선택 기능 구현하기</h1>
<form action="" name="form1">
	<fieldset>
		<legend>취미</legend>
		<p> <!-- 전체 선택용 체크박스 -->
			<input type="checkbox" id="all_check" value="Y">
			<label for="all_check"> 전체선택</label>
		</p>
		<p> <!-- 개별 항목들에 대한 체크박스 -->
			<input type="checkbox" name="hobby" id="hobby1" class="hobby_check" value="축구">
			<label for="hobby1">축구</label>
			<input type="checkbox" name="hobby" id="hobby2" class="hobby_check" value="농구">
			<label for="hobby2">농구</label>
			<input type="checkbox" name="hobby" id="hobby3" class="hobby_check" value="야구">
			<label for="hobby3">야구</label>
		</p>
		<input type="submit" value="제출">
	</fieldset>
</form>
</body>
</html>
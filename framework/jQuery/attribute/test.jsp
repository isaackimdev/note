<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
$(function() {
	// #all_check 요소의 상태가 변한 경우
	$("#all_check").change(function() {
		// 전체선택 체크박스의 체크상태 판별
		var is_check = $(this).is(":checked");
		// 하위 체크박스에 체크상태 적용
		$(".hobby_check").prop("checked", is_check);
	});
});
</script>

</head>
<body>
<h1>전체 선택 기능 구현하기</h1>
<form action="" name="form">
	<fieldset>
		<legend>취미</legend>
		<p><!-- 전체 선택용 체크박스 -->
			<input type="checkbox" id="all_check" value="Y">
			<label for="all_check"> 전체선택</label>
		</p>
		<p><!-- 개별 항목들에 대한 체크박스 -->
			<input type="checkbox" name="hobby" id="bobby1" class="hobby_check" value="축구">
			<label for="bobby1">축구</label>
			<input type="checkbox" name="hobby" id="bobby2" class="hobby_check" value="농구">
			<label for="bobby2">농구</label>
			<input type="checkbox" name="hobby" id="bobby3" class="hobby_check" value="야구">
			<label for="bobby3">야구</label>
		</p>
		<input type="submit" value="제출">
	</fieldset>
</form>
</body>
</html>
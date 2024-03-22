<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/event.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// #upload_file_check 요소의 상태가 변한 경우
		$("#upload_file_check").change(function() {
			var is_check = $(this).is(":checked");
			alert(is_check);
			// #file_finder 요소의 disabled 속성을 체크상태와 반대로 적용
			$("#file_finder").prop("disabled", !is_check);
		});
	});
</script>
</head>
<body>
<h1>활성/비활성 구현하기</h1>
<form action="" name="form1">
	<!-- 활성상태 제어용 체크박스 -->
	<input type="checkbox" id="upload_file_check" value="Y">
	<label for="upload_file_check">파일 올리기</label>
	<!-- 파일업로드 요소. 기본적으로 비활성 상태로 설정함 -->
	<input type="file" id="file_finder" disabled>
</form>
</body>
</html>
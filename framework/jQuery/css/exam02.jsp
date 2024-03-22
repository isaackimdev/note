<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 포커스가 들어온 경우 배경이미지 제거
		$("#id, #pw").focus(function() {
			$(this).css("background-image", "none");
		});
		// 포커스가 빠져 나간 경우...
		$("#id, #pw").blur(function() {
			// 입력값이 있다면?
			if($(this).val()) {
				$(this).css("background-image", "none");
			} else {
				$(this).css("background-image", "url(img/input.png)");
			}
		});
	});
</script>
<style type="text/css">
/** 입력영역의 크기 지정 */
fieldset {width:270px; height:100px;}
/** 입력 박스의 테두리, 크기, 여백, 배경이미지 지정 */
input{
	border:1px solid #ccc;
	width:240px; height: 25px;
	padding: 3px 10px 3px 10px;
	margin:5px;
	/** 배경이미지 지정 */
	background-image: url(img/input.png);
	background-repeat: no-repeat;
}
/** 배경이미지의 위치를 조정하여 클립핑 처리 */
input#id {background-position: 10px -3px;}
input#pw {background-position: 10px -43px;}

</style>
</head>
<body>
<form action="" name="form1">
	<fieldset style="border:1px solid gray">
		<legend>로그인</legend>
		<input type="text" name="user_id" id="id">
		<input type="password" name="user_pw" id="pw">
	</fieldset>
</form>
</body>
</html>



<!-- 
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

</script>
 -->
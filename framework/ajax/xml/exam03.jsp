<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/** id속성이 "checkid"인 요소에 대한 "click"이벤트 정의 */
		$("#checkid").click(function() {
			// 사용자 입력값 얻어오기
			var input_value = $("input[name='user_id']").val();
			// 입력여부 검사
			if(!input_value) {
				alert("아이디를 입력하세요.");
				$("input[name='user_id']").focus();
				return false;
			}
			/** 데이터파일의 URL설정 */
			// 웹 프로그래밍 연동 (JSP)
			var url = "ajax/idcheck/idcheck.jsp";
			/** get방식 ajax 연동 */
			$.get(url, {
				"user_id" :input_value
			}, function(data) {
				/** XML 데이터를 읽어왔을 떄,
				* 이 함수의 파라미터는 XML-DOM 형태이며,
				* 데이터를 추출하는 방법은 $.ajax() 함수와 동일하다. */
				// 데이터 로드에 성공한 경우 XML에서 "result"태그의 값을 추출
				var result_text = $(data).find("result").text();
				// "true" 혹은 "false"라는 문자열이므로,
				// eval함수를 사용하여 boolean값으로 변경
				var result = eval(result_text);
				// 결과 출력
				if(!result) {
					$(".console").html("<span style='color=blue;'>"
							+ "사용할 수 있는 아이디 입니다.</span>");
				} else {
					$(".console").html("<span style='color=red;'>"
							+ "사용할 수 없는 아이디 입니다.</span>");
				}
			});	
		});
	});
</script>
</head>
<body>
<h1 class="title">아이디 중복 검사</h1>
<div class="exec">
	<form action="">
		<input type="text" name="user_id">
		<input type="button" id="checkid" value="중복검사">
	</form>
</div>
<div class="console"></div>
</body>
</html>












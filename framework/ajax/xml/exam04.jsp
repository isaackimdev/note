<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
	/** 전체 여백 크기 초기화, 기본 글자색 지정 */
	* {padding: 0; margin: 0; color: #333; }
	body{padding: 20px 30px;}
	/** 폼 영역의 크기 및 테두리 */
	#login fieldset {
		width: 270px; padding: 15px;
		border: 1px solid #7BAEB5;
		position: relative;
	}
	#login fieldset legend {display:none; }
	/** 입력 항목 제목에 대한 설정 */
	#login label {
		display: inline-block;
		width: 80px;
		font-size: 14px;
		font-weight: bold;
		padding-left: 10px; margin-bottom: 10px;
	}
	/** 기본 입력박스의 형태 지정 */
	#login input[type='text'], #login input[type='password'] {
		border: 1px solid #ccc;
		padding: 3px 10px;
		width: 150px;
		vertical-align: middle;
		font-size: 12px; line-height: 150%;
	}
	/** 버튼의 크기 지정 */
	#login input[type='submit'] {
		width: 270px; height: 20px;
	}
	/** 활성화 input 에 적용할 스타일 */
	.active {
		border: 1px solid #f00 !important;
		background-color: #98BF21;
	}
	/** 로딩박스 */
	#login {position: relative;}
	#login fieldset .loader {
		position: absolute;
		left: 0; top: 0;
		width:100%; height: 100%;
		background-color: rgba(0,0,0,0.3);
		display: none;
	}
	/** 이미지를 로딩박스 안에서 가운데 배치하기 */
	#login .loader img {
		position: absolute;
		left: 50%; top:50%;
		margin-left: -15px; margin-top: -15px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		// #user_id 요소와 #user_password 두 요소에 대한,
		// focus, blur 이벤트 처리
		// --> bind 용법 사용함
		$("#user_id, #user_password").bind({
			"focus": function() {
				$(this).addClass("active");
			},
			"blur" : function() {
				$(this).removeClass("active");
			}
		});
		// 폼에 대한 submit event 처리 --> 입력값 여부 검사를 수행한다.
		$("#login").bind({"submit" : function() {
			/** 입력 여부 검사 */
			if(!$("#user_id").val()) {
				alert("아이디를 입력하세요.");
				$("#user_id").focus();
				return false;
			}
			if(!$("#user_password").val()) {
				alert("비밀번호를 입력하세요.");
				$("#user_password").focus();
				return false;
			}
			// 로딩처리 보여주기
			$("#login .loader").show();
			/** 로그인처리에 대한 JSP예시 */
			var url = "ajax/login/login.jsp";
			/** ajax 로그인 처리 **/		// 폼태그를 나타냄
			var ajax = $.post(url, $(this).serialize(), function(data){
				// XML에서 result태그와 message태그의 내용 추출
				var result = $(data).find("result").text();
				var message = $(data).find("message").text();
				// result값은 boolean형으로 변환.
				var result_value = eval(result);
				// 결과메시지 출력
				alert(message);
				// 결과에 따른 후속 처리
				if(result_value) {
					// 로그인 성공시 처리할 부분
				} else {
					// 로그인 실패시 처리할 부분
				}
			}).fail(function() {
				alert("로그인에 실패하였습니다. 잠시후에 다시 시도해 주세요.");
			}).always(function() {
				$("#login .loader").hide();	
			});
		}
		});
	});
</script>
</head>
<body>
<form action="" id="login">
	<fieldset>
		<legend>로그인</legend>
		<div>
			<label for="user_id">아이디</label>
			<input type="text" name="user_id" id ="user_id">
		</div>
		<div>
			<label for="user_password">비밀번호</label>
			<input type="password" name="user_password" id ="user_password">
		</div>
		<div>
			<input type="submit" value="로그인">
		</div>
		<div class="loader"><img src="img/loader.gif"></div>
	</fieldset>
</form>
</body>
</html>
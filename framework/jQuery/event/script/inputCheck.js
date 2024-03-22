$(function(){
	// id 속성이 join인 <form>태그 안의 submit 버튼을 누른 경우
	$("#join").submit(function(){
		/** 아이디 입력검사 */
		// $(input요소).val() 는 사용자가 입력한 값을 리턴한다.
		var user_id = $("input[name='user_id']").val();
		if(!user_id) {	// user_id == ""
			alert("아이디를 입력하세요.");
			$("input[name='user_id'").focus();
			return false;
		}
		/** 비밀번호 입력검사 */
		if(!$("input[name='user_pw']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='user_pw']").focus();
			return false;
		}
		/** 주민번호 입력검사 */
		if(!$("input[name='juminno']").val()) {
			alert("주민번호를 입력하세요.");
			$("input[name='juminno']").focus();
			return false;	
		}
		/** 라디오버튼 선택여부 검사 */
		// !$("라디오버튼 CSS 셀렉터").is(" :checked") --> 체크일 경우 : true
		if(!$("input[name='gender']").is(":checked")) {
			alert("성별을 선택하세요.");
			$("input[name='gender']:eq(0)").focus();
			return false;	
		}
		
		/** 이메일주소 입력여부 검사 */
		if(!$("input[name='email']").val()) {
			alert("이메일 주소를 입력하세요.");
			$("input[name='email']").focus();
			return false;	
		}
		
		/** 홈페이지 주소 입력여부 검사 */
		if(!$("input[name='url']").val()) {
			alert("홈페이지 주소를 입력하세요.");
			$("input[name='url']").focus();
			return false;
		}
		
		/** 핸드폰 번호 입력여부 검사 */
		if(!$("input[name='hpno']").val()) {
			alert("핸드폰 번호를 입력하세요.");
			$("input[name='hpno']").focus();
			return false;	
		}
		
		/** 체크박스 선택여부 검사 */
		if(!$("input[name='hobby']").is(":checked")) {
			alert("취미를 선택하세요.");
			$("input[name='bobby']:eq(0)").focus();
			return false;	
		}
		
		/** select box 선택여부 검사 */
		if($("select[name='job'] > option:selected").index() < 1) {
			alert("직업을 선택하세요.");
			$("select[name='job']").focus();
			return false;		
		} 
		
		/** 입력 내용을 화면에 출력해 봅시다. */
		var user_id = $("input[name='user_id']").val();
		var user_pw = $("input[name='user_pw']").val();
		var juminno = $("input[name='juminno']").val();
		var gender = $("input[name='gender']:checked").val();
		var email = $("input[name='email']").val();
		var url = $("input[name='url']").val();
		var hpno = $("input[name='hpno']").val();
		var job = $("select[name='job'] > option:selected").val();
		// 체크박스의 선택항목 값들을 추출
		var hobby = $("input[name='hobby']:checked");
		// 추출된 값을 누적하여 저장할 문자열 변수
		var select_hobby = "";
		// hobby의 개체 수 만큼 반복적으로 function()이 실행된다.
		hobby.each(function() {
			// 각 반복되는 처리 안에서 $(this)는 hobby안에 포함된 개체이다.
			// --> 체크된 n번째 체크박스임
			// 추출된 값을 누적 저장한다.
			select_hobby += $(this).val() + ",";
		});
		
		// 출력할 문자열 만들기
		var result ="<ul>";
		result += "<li>아이디 : " + user_id + "</li>";
		result += "<li>비밀번호 : " + user_pw + "</li>";
		result += "<li>주민번호 : " + juminno + "</li>";
		result += "<li>성별 : " + gender + "</li>";
		result += "<li>이메일 : " + email + "</li>";
		result += "<li>홈페이지 : " + url + "</li>";
		result += "<li>핸드폰 번호 : " + hpno + "</li>";
		result += "<li>취미 : " + select_hobby + "</li>";
		result += "<li>직업 : " + job + "</li>";
		result += "</ul>";
		
		$("body").html(result);
		// submit되면 결과 확인이 안되므로 전송처리 강제 종료
		return false;
	});
});
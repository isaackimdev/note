<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment</title>
<style type="text/css">
	* {padding: 0; margin: 0; color: 333;}
	#container {padding: 30px 20px;}
	ul {list-style: none;}
	h1 {
		font-size: large;
		border-left: 10px solid #7BAEB5;
		border-bottom: 1px solid #7BAEB5;
		padding: 10px;
		width: auto;
	}
	#comment_write {padding: 20px 15px; border-bottom: 1px solid #7BAEB5;}
	#comment_write label {
		display: inline-block; width: 80px;
		font-size:14px; font-weight: bold;
		margin-bottom: 10px;
	}
	#comment_write input[type='text'], #comment_write textarea {
		border: 1px solid #ccc;
		vertical-align: middle;
		padding: 3px 10px;
		font-size: 12px;
		line-height: 150%;
	}
	#comment_write textarea {
		width: 380px; height: 90px;
	}
	/** 존재하지 않은 태그, 추가해줄 예정인 태그 */
	.comment_item {
		font-size: 13px;
		color: #333;
		padding: 15px;
		border-bottom: 1px dotted #ccc;
		line-height: 150%;
	}
	.comment_item .write { color: #555; line-height: 200%;}
	.comment_item .write input { vertical-align: middle;}
	.comment_item .write .name {color: #222; font-weight: bold; font-size: 14px}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	/** 새로운 글을 화면에 추가하기 위한 함수
	* - num : 글 번호
	* - writer : 작성자 이름
	* - content : 덧글 내용
	* - datetime : 작성일시  */
	function addNewItem(num, writer, content, datetime) {
		// 새로운 글이 추가될 li태그 객체
		var new_li = $("<li>");
		new_li.attr("data-num", num);
		new_li.addClass("comment_item");
		// 작성자 정보가 지정될 <p>태그
		var writer_p = $("<p>");
		writer_p.addClass("writer");
		// 작성자 정보의 이름
		var name_span = $("<span>");
		name_span.addClass("name");
		name_span.html(writer + "님");
		// 작성일시
		var date_span = $("<span>");
		date_span.html(" / " + datetime + " ")
		// 삭제하기 버튼 
		var del_input = $("<input>");
		del_input.attr({"type" : "button", "value" : "삭제하기"});
		del_input.addClass("delete_btn");
		// 내용
		var content_p = $("<p>");
		content_p.html(content);
		// 조립하기
		writer_p.append(name_span).append(date_span).append(del_input);
		new_li.append(writer_p).append(content_p);
		$("#comment_list").append(new_li);
	}

	$(function() {
		/** 기본 덧글 목록 불러오기 */
		$.get("ajax/comment/comment_list.xml", {}, function(data) {
			// 읽어들인 XML에서 "item"태그를 찾아 반복처리
			$(data).find("item").each(function() {
				var num = $(this).find("num").text();
				var writer = $(this).find("writer").text();
				var content = $(this).find("content").text();
				var datetime = $(this).find("datetime").text();
				addNewItem(num, writer, content, datetime);
			});			
		}).fail(function() {
			alert("덧글 목록을 불러오는데 실패하였습니다. 잠시후에 다시 시도해 주세요.");
		});
		/** 덧글 내용 저장 이벤트 */
		$("#comment_form").submit(function() {
			// 작성자 이름에 대한 입력여부 검사
			if(!$("#user_name").val()) {
				alert("이름을 입력하세요.");
				$("#user_name").focus();
				return false;
			} 
			// 내용에 대한 입력여부 검사
			if(!$("#comment").val()) {
				alert("내용을 입력하세요.");
				$("#comment").focus();
				return false;
			} 
			/** 덧글쓰기에 대한 JSP예시 */
			var url = "ajax/comment/comment_write.jsp";
			/** 글 저장을 위한 Post 방식의 Ajax 연동 처리 */
			$.post(url, $(this).serialize(), function(xml) {
				// XML에서 "result"태그의 값을 추출해서 식으로 변환
				// --> true or false
				var result = eval($(xml).find("result").text());
				// 결과가 저장 실패를 의미한다면 에러 메시지 출력 후, 처리 중단.
				if(!result) {
					alert($(xml).find("message").text());
					return;
				}
				// 위의 if문을 지나친다면 저장 성공이므로, 저장된 결과를 추출
				var num = $(xml).find("num").text();
				var writer = $(xml).find("writer").text();
				var content = $(xml).find("content").text();
				var datetime = $(xml).find("datetime").text();
				// 저장 결과를 새로운 목록으로 출력하기 위해서 함수 호출
				addNewItem(num, writer, content, datetime);
			}).fail(function() {
				alert("덧글 작성에 실패했습니다. 잠시 후에 다시 시도해 주세요.");
			});
			return false;
		});
		
		/** 삭제 버튼 클릭시에 항목 삭제하도록 "미리" 지정 */
			// 현재 존재하지 않는 것의 처리방법으로 $(document).on 을 사용
		$(document).on("click", ".delete_btn", function() {
			if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")) {
				// 덧글 삭제를 가정한 JSP파일
				var url = "ajax/comment/comment_delete.jsp";
				// 글번호 얻기
				var num = $(this).parents("li").attr("data-num");
				// 삭제 제거 대상
				// --> 클릭된 버튼을 기준으로 "comment_item"이라는 클래스를 갖는 상위 요소
				var target = $(this).parents(".comment_item");
				/** 글 번호를 통하여 삭제를 요청함  */
				$.post(url, {"num" : num}, function(xml) {
					// XML에서 "result"태그의 값을 추출해 식으로 변환 --> true, false
					var result = eval($(xml).find("result").text());
					// 결과 메시지
					var message = $(xml).find("message").text();
					// 메시지 출력
					alert(message);
					// 삭제 성공을 의미할 경우, 삭제 대상 요소를 화면에서 제거
					if(result) {
						target.remove();
					}
				}).fail(function() {
					alert("덧글 삭제에 실패했습니다. 잠시 후에 다시 시도해 주세요.");
				});
			}
		});
	});
		
</script>
</head>
<body>
<div id="container">
	<h1>jQuery Comment</h1>
	<div id="comment_write">
		<form action="" id="comment_form">
			<div>
				<label for="user_name">작성자</label>
				<input type="text" name="user_name" id="user_name">
				<input type="submit" value="저장하기">
			</div>
			<div>
				<label for="comment">덧글 내용</label>
				<textarea name="comment" id="comment"></textarea>
			</div>
		</form>
	</div>
	<ul id="comment_list">
		<!-- 여기에 동적 생성 요소가 들어가게 됩니다. -->
	</ul>
</div>
</body>
</html>

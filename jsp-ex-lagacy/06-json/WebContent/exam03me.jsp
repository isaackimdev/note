<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>article</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<style type="text/css">
table {
	display: block; width: 100%;
	font-size: 14px; text-align: center;
}
table tr:after {
	content: ''; display: block; float: none; clear: both;	
}
table .left {text-align: left;}
thead, tbody, tr {display: block; width: 100%;}
td, th {display: block; float: left; padding: 10px 0;}
table thead {border-bottom: 2px solid #285E8E; font-weight: bold;}
table tbody tr {border-bottom: 1px dotted #ccc;}
.example table .no {width: 10%;}
.example table .subject {width: 60%;}
.example table .hit {width: 10%;}
.example table .date {width: 20%;}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>	<!-- 설정 파일 에러 : 위치 주의하세요~~ -->
<script type="text/javascript" src="plugins/tmpl/jquery.tmpl.min.js"></script>
<!-- 템플릿으로 사용할 HTML태그 -->
<script type="text/x-jquery-tmpl" id="itemTemplate">
	<tr>
		<td class="no">\${no}</td>
		<td class="left subject">\${subject}</td>
		<td class="hit">\${hit}</td>
		<td class="date">\${date}</td>
	</tr>
</script>

<script type="text/javascript">
	$(function() {
		/** get방식으로 json 데이터의 요청 */
		$.get("ajax/json/bbs.json", {}, function(json) {
			// JSON이므로 별도의 추출 과정 업이 점(.)으로
			// 데이터 계층을 연결하여 사용할 수 있다.
			/** 제목, 내용, 전체 글 수를 화면에 출력 */
			$("h1.title").html(json.title);
			$("div.exec:eq(0)").html(json.description);
			$("div.exec:eq(1) > span").html(json.total);
			// 글 항목을 담고 있는 배열을 템플릿에 통째로 지정
			var tmpl = $("#itemTemplate").tmpl(json.item);
			// 화면에 출력
			$("div.example > table > tbody").append(tmpl);
		});
	});
</script>
</head>
<body>
<!-- 게시판 제목이 출력될 곳 -->
<h1 class="title"></h1>
<!-- 게시판 설명이 출력될 곳 -->
<div class="exec"></div>
<div class="exec">
	<!-- 게시물 수 출력될 곳 -->
	총 게시물 수 : <span></span>개
</div>
<div class="example">
	<table>
		<thead>
			<tr>
				<th class="no">번호</th>
				<th class="subject">제목</th>
				<th class="hit">조회수</th>
				<th class="date">작성일시</th>
			</tr>
		</thead>	
		<tbody>
			<!-- 목록이 출력될 곳 -->
		</tbody>
	</table>
</div>
</body>
</html>
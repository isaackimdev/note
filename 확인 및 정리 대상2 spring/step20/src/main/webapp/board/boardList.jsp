<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript" src="../script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type: "POST",
			url: "boardListJson.do",
			data: {"pg": "${pg}"},
			dataType: "json",
			success: function(data) {
				$.each(data.items, function(index, item) {
					/** 결과를 출력하기 위한 동적 요소의 생성 */
					var tr = $("<tr>", {align : "center"});
					var td1 = $("<td>").html(item.seq);
					var td2 = $("<td>").append($("<a>", {
						id: "subjectA",
						href: "#",
						click : function() {
							if(${memId == null}) {
								alert("먼저 로그인 하세요");
							} else {
								location.href="boardView.do?seq=" + item.seq 
										+ "&pg=" + ${pg}; 
							}
						},
						text: item.subject
					}));
					
					var td3 = $("<td>").html(item.id);
					var td4 = $("<td>").html(item.logtime);
					var td5 = $("<td>").html(item.hit);
					
					tr.append(td1).append(td2).append(td3).append(td4).append(td5);
					$("#boardListT").append(tr);
				});
			}
		});
	});
</script>

<style type="text/css">
#subjectA:link { color:black; text-decoration: none; }
#subjectA:visited { color:black; text-decoration: none; }
#subjectA:hover { color:green; text-decoration: underline; }
#subjectA:achive { color:black; text-decoration: none; }

#currentPaging { color: red;  text-decoration: underline; }
#paging { color: blue;	text-decoration: none; }
</style>

</head>
<body>
<table border="1" cellpadding="5">
	<tr bgcolor="ffff00">
		<th width="70">글번호</th>
		<th width="200">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="70">조회수</th> 
	</tr>
	
	<tbody id="boardListT">
		<!-- 목록 삽입 -->
	</tbody>
	
	<!-- 페이징 -->
	<tr>
		<td colspan="5" align="center">
		<c:if test="${startPage > 3}" >
				[<a id="paging" href="boardList.do?pg=${startPage - 1}">이전</a>]
		</c:if>			
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${i == pg }">
					[<a id="currentPaging" href="boardList.do?pg=${i }" >${i }</a>]
				</c:if>
				<c:if test="${i != pg }">
					[<a id="paging" href="boardList.do?pg=${i }" >${i }</a>]
				</c:if>	
		</c:forEach>
		
		<c:if test="${endPage < totalP}" >
				[<a id="paging" href="boardList.do?pg=${endPage+1}">다음</a>]
		</c:if>
		</td>
	</tr>
</table>
<br>
<a href="boardWriteForm.do">새글쓰기</a>
</body>
</html>
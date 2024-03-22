<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판</title>
<style type="text/css">
#currentPaging {color:red; text-decoration: underline;}
#paging {color:blue; text-decoration: none;}

.currentPaging {
	color:red;
	text-decoration: underline;
}
.paging {
	color: blue;
	text-decoration: none;
}

</style>
</head>
<body>


<table border="1">
	<tr>
		<th width="50">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
	
<c:forEach var="imageboardDTO" items="${list }">
	<tr align="center">
		<td>${imageboardDTO.seq }</td>
		<td>
			<a href="imageboardView?seq=${imageboardDTO.seq}&pg=${pg}">
				<img src="../storage/${imageboardDTO.image1 }" width="50", height="50">
			</a>
		</td>
		<td>${imageboardDTO.imageName }</td>
		<td>${imageboardDTO.imagePrice }</td>
		<td>${imageboardDTO.imageQty }</td>
		<td>${imageboardDTO.imagePrice * imageboardDTO.imageQty }</td>
	</tr>
</c:forEach>
<!-- 페이징 -->
	<tr>
		<td colspan="6" align="center">
		<c:if test="${startPage>3 }">
			[<a class="paging" href="imageboardList?pg=${startPage - 1 }">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:if test="${i == pg }">
			[<a class="currentPaging" href="imageboardList?pg=${i }">${i }</a>]
			</c:if>
			
			<c:if test="${i != pg }">
			[<a class="paging" href="imageboardList?pg=${i }">${i }</a>]
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < totalP }">	
			[<a class="paging" href="imageboardList?pg=${endPage + 1 }">다음</a>]
		</c:if>
		</td>
	</tr>
</table>
<a href="imageboardWriteForm">이미지 등록</a>



<hr>



<table border="1" cellpadding="5">
	<tr>
		<th width="50">번호</th>
		<th width="100">이미지</th>
		<th width="100">상품명</th>
		<th width="100">상품단가</th>
		<th width="100">상품개수</th>
		<th width="100">합계</th>
	</tr>
<c:forEach var="imageboardDTO" items="${list }">
	<tr align="center" >
		<td>${imageboardDTO.seq }</td>
		<td>
			<a href="imageboardView?seq=${imageboardDTO.seq }&pg=${pg } ">
				<img width="50" height="50" src="../storage/${imageboardDTO.image1 }">
			</a>
		</td>
		<td>${imageboardDTO.imageName }</td>
		<td>${imageboardDTO.imagePrice }</td>
		<td>${imageboardDTO.imageQty }</td>
		<td>${imageboardDTO.imagePrice * imageboardDTO.imageQty }</td>
	</tr>
</c:forEach>
	
	<tr>
		<td colspan="6" align="center">
			
			<c:if test="${startPage > 3 }">
				[<a id="paging" href="imageboardList?pg=${startPage-1 }">이전</a>]
			</c:if>
			
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">  
				<c:if test="${pg == i}">
						[<a id="currentPaging" href="imageboardList?pg=${i }">${i}</a>]
				</c:if>
				<c:if test="${pg != i}">
						[<a id="paging" href="imageboardList?pg=${i }">${i}</a>]
				</c:if>
				
			</c:forEach>
			
			<c:if test="${endPage < totalP }" >
					[<a id="paging" href="imageboardList?pg=${endPage+1 }">다음</a>]
			</c:if>
			
		</td>
	</tr>
</table>
<br>
<a href="imageboardWriteForm">이미지 등록하기</a>

</body>
</html>
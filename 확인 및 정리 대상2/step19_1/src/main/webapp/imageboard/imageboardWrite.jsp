<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// onload : html 전체 로딩된 이후에 실행됨
	window.onload = function() {
		if(${su > 0}) {
			alert("이미지를 저장하였습니다.");
			location.href="imageboardList?pg=1";
		} else {
			alert("이미지를 저장하지 못했습니다.");
			location.href="imageboardWriteForm";
		}
	}
	
</script>
</head>
<body>

<c:if test="${su>0 }">
	<p>작성하신 글을 저장하였습니다.</p>
</c:if>

<c:if test="${su == 0 }">
	<p>작성하신 글을 저장하지 못했습니다.</p>
</c:if>

파일 이름 : ${imageboardDTO.image1 }

<br>
<img alt="" src="../storage/${imageboardDTO.image1 }">
<!-- 새로고침을 해야 그림을 볼 수 있지만, 정식서버에서는 제대로 동작함 
- storage 폴더에 저장된 파일은 refresh (f5)를 해야만 보인다.
-->
<!-- 
	STS.exe > window > preferences > general > workspace > refresh
 -->

</body>
</html>
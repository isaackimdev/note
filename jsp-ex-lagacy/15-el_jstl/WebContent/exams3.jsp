<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h3>** 변수 설정 **</h3>
<c:set var="name">홍길동</c:set>
<c:set var="age" value="25"/>
<!-- JSTL 사용 -->
<!-- JSTL에서 사용되는 변수 설정 -->
<!-- 변수설정은 C:set 변수 사용 EL표현식 $ {} -->
나의 이름은 <c:out value="${name }"/> 입니다<br>
내 나이는 ${age }살 입니다.<br>
나의 키는 ${height }입니다.<br>

<h3>** 변수 삭제**</h3>
<c:remove var="name"/>
나의 이름은 <c:out value="${name }"/> 입니다<br>
내 나이는 ${age }살 입니다.<br>
나의 키는 ${height }입니다.<br>

<!-- for문 대체 : 일반 for문 대체 -->
<h3>** forEach **</h3>
<c:forEach var="i" begin="1" end="10" step="1">
	${i} &nbsp;&nbsp;
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>
<br>
<p>1~10 까지의 합 = ${sum }</p>
<br><br>

<!-- for문 대체 : 확장 for문 대체 -->
<c:set var="arr" value="10, 20, 30, 40, 50"/>
<c:forEach var="data" items="${arr}">	<!-- for(int data : arr) -->
	${data} &nbsp;&nbsp;
</c:forEach>
<br>

<h3>** 문자열 분리 **</h3>
<c:forTokens var="car" items="소나타,그렌저,아우디,링컨,페라리" delims=",">
	${car } &nbsp;&nbsp;
</c:forTokens>
<br>

<h3>** if **</h3>
<c:set var="age" value="15"/>
<c:if test="${age>=19 }">
	성인
</c:if>
<c:if test="${age<19 }">
	청소년
</c:if>
<br>

<h3>** switch **</h3>
<c:set var="color" value="red,green,blue,magenta,cyan"/>
<c:forEach var="data" items="${color }">
	<c:choose>
		<c:when test="${data=='red' }">빨강</c:when>
		<c:when test="${data=='green' }">초록</c:when>
		<c:when test="${data=='blue' }">파랑</c:when>
		<c:when test="${data=='magenta' }">보라</c:when>
		<c:otherwise>하늘</c:otherwise>
	</c:choose>
</c:forEach>

</body>
</html>













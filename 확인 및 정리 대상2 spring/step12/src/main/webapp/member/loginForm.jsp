<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="login.do" name="loginForm" method="post">
<table border="1">
	<tr>
		<td width="70" align="center">아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입">
		</td>
	</tr>
</table>
</form>


</body>
</html>

<!--
	0. pom.xml에서 JDBC / 오라클 Driver 등 Dependency 설정 해야 함.
		- 버전 설정 1 : Generic properties 1.8 / Spring 4.3.6
	
	 스프링 웹 을 만들고 무조건 해야될 동작이 있다.
	처음 세팅이 중요 함..
	1. Maven update하고
	콘솔 > 서버 > add and remove 서버 등록 > 
	
	2. 메이븐 업데이트를 하게되면,
	현재 자바 버전이 1.5 상태임
	
	- 프로젝트 파일에서 > build path에서 JRE 버전 1.8로 수정
		- 버전 설정 2
		
	3. 프로젝트 파일명에 > 오른쪽마우스 클릭 > Properties >	Java _ Maven _ project Facets > version 1.8
		- 버전 설정 3
		
	4. 자바스크립트가 실행이 안될때,
		src > webapp > WEB-INF > mvc-config.xml 
		- 특정폴더 인식시키는 작업이 필요함
		-mvc:resources
	

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 내장 객체 예제</title>
</head>
<body>
	<h2>application 내장 객체</h2>
<%
	String info = application.getServerInfo();
	String path = application.getRealPath("/");	// 절대경로에 끝에 "\" 추가 시킴
	application.log("로그 기록 : " + info);			// Console 창에 내용을 로그내용 출력
	System.out.println("로그 기록 : " + info);	// 서버에 관한 내용 총 객체를 확인하는 내장 객체
											// application 프로젝트 전체를 관리하는 내장 객체 
											// 프로젝트 전체가 공통으로 관리할때 application으로 공통으로 관리할때 사용.
%>
	<p>웹 컨테이너의 이름과 버전 : <%=info %></p>
	<p>웹 어플리케이션 폴더의 로컬 시스템 경로 : <%=path %></p>

</body>
</html>
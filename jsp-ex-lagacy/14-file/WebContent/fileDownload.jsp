<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 데이터
	String fileName = request.getParameter("fileName");
	// 실제 폴더
	String realFolder = request.getServletContext().getRealPath("/storage");
	// 다운받고자 하는 파일
	File file = new File(realFolder, fileName);
	System.out.println("file = " + file);
	// 화면이 아닌 "파일 다운로드 " 형태로 전송되게 된다.  // HTML이 아니라  다른 것로 보내야 한다고 함.
	 response.setHeader("Content-Disposition", "attachment;fileName="
	 		+ new String(URLEncoder.encode(fileName, "UTF-8")).replaceAll("\\+"," "));
	response.setHeader("Content-Length", String.valueOf(file.length()));	// String.valueOf() 는 문자열로 변경해주는 메소드
	out.clear();
	out = pageContext.pushBody();	// 기존 jsp의 객체 out의 스트림을 지우고 출력해야
									// 예외 발생이 안생김
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));		// tomcat은 web서버를 거쳐서 처리됨  // 읽기클래스
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());	// 쓰기 클래스
	
	// 읽어들일 byte[] 
	byte[] b = new byte[(int)file.length()];
	bis.read(b, 0, b.length);	// 0번 위치부터 쫘악 읽기,  b배열에
	bos.write(b);
	bis.close();
	bos.close();	// 닫기
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	// 실제 저장 폴더 찾기
	String realFolder=request.getServletContext().getRealPath("/storage");
	System.out.println("realFolder = " + realFolder);
	// 업로드
	// 5*1024*1024 = 5MB
	// DefaultFileRenamePolicy
	// : 업로드시, 똑같은 파일이름이 있을 경우, 기존 파일이름에 숫자를 덧붙여서 저장한다.
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,	// new 하면서 실제 폴더에 저장함.
			"UTF-8", new DefaultFileRenamePolicy());							// request는 문자열을 받아 옴. 그래서 MultipartRequest를 씀
	
	// 데이터
	String subject = multi.getParameter("subject");		// 데이터를 가져옴
	String content = multi.getParameter("content");
	String originalFileName1 = multi.getOriginalFileName("upload1");	// 원래 이름
	String originalFileName2 = multi.getOriginalFileName("upload2");
	String fileName1 = multi.getFilesystemName("upload1");		// 실제 파일이 저장될때 이름
	String fileName2 = multi.getFilesystemName("upload2");		// 절대 경로 
	
	File file1 = multi.getFile("upload1");
	File file2 = multi.getFile("upload2");
	System.out.println("file1 = " + file1);
	System.out.println("file2 = " + file2);
	
	long fileSize1 = 0;
	long fileSize2 = 0;
	if(file1 != null) fileSize1 = file1.length();
	if(file2 != null) fileSize2 = file2.length();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h2>파일 업로드</h2>
<p>업로드 완료!!</p><br>
<ul>
	<li>제목 : <%=subject %></li>
	<li>내용 : <%=content %></li>
	<li>파일 : <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName1, "UTF-8") %>"><%=originalFileName1 %></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=fileName1 %></li>
	<li>크기 : <%=fileSize1 %></li>
	<li>파일 : <%=originalFileName2 %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=fileName2 %></li>
	<li>크기 : <%=fileSize2 %></li>
</ul>

</body>
</html>
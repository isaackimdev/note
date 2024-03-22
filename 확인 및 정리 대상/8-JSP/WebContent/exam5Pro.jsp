<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double) tot/3;
		String grade="";
		switch((int)(avg/10)) {
		case 10: 
		case 9 : grade = "수"; break;
		case 8 : grade = "우"; break;
		case 7 : grade = "미"; break;
		case 6 : grade = "양"; break;
		default : grade = "가"; break;
		}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=name %>님의 성적은   &lt; <%=grade %> &gt; 입니다.
</body>
</html>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 가져오기
	request.setCharacterEncoding("utf-8");	// 한글 엔코딩
	String name = request.getParameter("name");			// 네임 값으로 value 불러오기
	String id = request.getParameter("id");				// 네임 값으로 value 불러오기
	String pwd = request.getParameter("pwd");			// 네임 값으로 value 불러오기
	String gender = request.getParameter("gender");		// 네임 값으로 value 불러오기
	String email1 = request.getParameter("email1");		// 네임 값으로 value 불러오기
	String email2 = request.getParameter("email2");		// 네임 값으로 value 불러오기
	String tel1 = request.getParameter("tel1");			// 네임 값으로 value 불러오기
	String tel2 = request.getParameter("tel2");			// 네임 값으로 value 불러오기
	String tel3 = request.getParameter("tel3");			// 네임 값으로 value 불러오기
	String addr = request.getParameter("addr");			// 네임 값으로 value 불러오기
	// 클라이언트 회원가입 폼 화면에서 가지고온 데이터를 DTO에 저장
	
	// 데이터 저장
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setTel1(tel1);
	memberDTO.setTel2(tel2);
	memberDTO.setTel3(tel3);
	memberDTO.setAddr(addr);
	// DB		-- 사용하는 클래스는 import 하여야만 사용할 수 있음.
	// JDBC 활용하기
	MemberDAO memberDAO = new MemberDAO();
	int su = memberDAO.write(memberDTO);	// 회원가입하여 DB에 쓰여져서 업데이트 된 경우 그 업데이트된 +1 숫자가 su 에 저장 됨.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(서버)</title>
</head>
<body>
<!-- 회원가입 성공과 실패여부 만들기 -->
	<% if(su==0) { %>
		<p> 회원 가입 실패</p>
	<% } else { %>
		<p> 회원가입 성공</p>
	<% } %>
	
<%-- 전체 값 불러와짐 확인 완료
	이름 : <%=name %><br>
	아이디 : <%=id %><br>
	암호 : <%=pwd %><br>
	성별 : <%=gender %><br>
	이메일 : <%=email1 %>@<%=email2 %><br>
	핸드폰 : <%=tel1 %> - <%=tel2 %> - <%=tel3 %><br>
	주소: <%=addr %><br>
--%>

</body>
</html>
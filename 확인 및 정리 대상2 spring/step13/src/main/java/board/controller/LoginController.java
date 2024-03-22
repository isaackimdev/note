package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// 2. DB 연동 처리
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 3. 화면 네비게이션
		if(name == null) {	// 로그인 실패
			// response.sendRedirect("loginForm.jsp");
			return "loginForm";
		}	else {		// 로그인 성공
			HttpSession session = request.getSession();	// 세션 얻어오기
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// forward 방식으로 보내면 폴더명이 안바뀜
			// 다른 폴더 일때는 sendRedirect가 편함..
		
			return "../board/boardList.do?pg=1";
		}
	}

}












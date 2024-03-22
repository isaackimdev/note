package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;

/* 이전 챕터에서 mvc-config > controller 등록 코드를 대체함 */
@Controller
public class LoginController {
	
	@RequestMapping(value="/member/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value="/member/login")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// 2. DB 연동 처리
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		if(name == null) {	// 로그인 실패
			// response.sendRedirect("loginForm.jsp");
			//return "loginForm";
			modelAndView.setViewName("member/loginForm");
		}	else {		// 로그인 성공
			HttpSession session = request.getSession();	// 세션 얻어오기
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// forward 방식으로 보내면 폴더명이 안바뀜
			// 다른 폴더 일때는 sendRedirect가 편함..
			//return "../board/boardList.do?pg=1";
			modelAndView.setViewName("redirect:../board/boardList");
			System.out.println("게시판 목록화면으로 이동");
			modelAndView.addObject("pg", 1);
			return modelAndView;
		}
		return modelAndView;
	}

}












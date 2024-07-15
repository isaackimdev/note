package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.dao.MemberDAO2;

@Controller
public class MemberController {
	
	// 메인화면
	@RequestMapping(value="main/index")
	public ModelAndView index() {
		System.out.println("메인 화면 처리");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main/index");
		return modelAndView;
	}
	
	// 회원가입 화면
	@RequestMapping(value="member/writeForm")
	public ModelAndView writeForm() {
		System.out.println("회원가입 폼 화면 처리");
		// String return "redirect:../member/writeForm.jsp";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/writeForm");
		return modelAndView;
	}
	
	// 아이디 중복체크 뷰
	@RequestMapping(value="member/checkId")
	public ModelAndView checkId(HttpServletRequest request) {
		System.out.println("중복확인 체크 화면 처리");
		// 사용자 입력 데이터 처리
		String id = request.getParameter("id");
		// DB 처리
		MemberDAO2 memberDAO = new MemberDAO2();
		boolean exist = memberDAO.isExistId(id);
		
		System.out.println(id);
		System.out.println(exist);
		
		// 데이터 담아 보내기
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);	
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("member/checkId");
		return modelAndView;
	}
	
	// 회원가입
	@RequestMapping(value="member/write")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("회원가입 데이터 DB 저장 처리");
		// 사용자 입력 데이터 처리
		//데이터 읽어오기
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		//데이터 저장
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
		//DB 처리
		MemberDAO2 memberDAO = new MemberDAO2();
		int su = memberDAO.write(memberDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("member/write");
		return modelAndView;
	}
	
	// 로그인 입력 화면 처리
	@RequestMapping(value="member/loginForm")
	public String loginForm() {		
		System.out.println("로그인 입력 폼 처리");
		return "member/loginForm";
	}
	
	// 로그인 데이터 처리
	@RequestMapping(value="member/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 데이터 처리");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//데이터 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO2 memberDAO = new MemberDAO2();
		String name = memberDAO.login(id, pwd);
		// 데이터 공유 및 view 처리
		ModelAndView modelAndView = new ModelAndView();

		if(name == null) {	// 로그인 실패
			System.out.println("[분기문]로그인 실패");
			modelAndView.setViewName("member/loginFail");
		} else if (name != null) {	// 로그인 성공
			System.out.println("[분기문]로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			modelAndView.setViewName("member/loginOk");			
		}
		return modelAndView;
	}
	
	// 로그인 실패 처리
	@RequestMapping(value="member/loginFail")
	public String loginFail() {
		System.out.println("로그인 실패 처리");
		return "member/loginFail";
	}
	
	// 로그아웃 처리
	@RequestMapping(value="member/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		// 입력정보 처리
		HttpSession session = request.getSession();
		//세션 삭제
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		// 무효화 : 모두 지우기
		session.invalidate();	
		
		// view 처리
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/logout");
		return modelAndView;
	}	
}
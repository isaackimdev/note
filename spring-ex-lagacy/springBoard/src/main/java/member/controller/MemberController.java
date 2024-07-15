package member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired	// Autowired로 주입 받으면 된다.
	private MemberService memberService;
	// 파일과 함수이름을 똑같이 줄 것.
	@RequestMapping(value="/main/index.do")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../main/index.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/member/writeForm.do")
	public String writeForm() {
		return "writeForm.jsp";
	}

	@RequestMapping(value="/member/write.do")
	public ModelAndView write(HttpServletRequest request) throws IOException {
		//데이터 읽어오기
		request.setCharacterEncoding("utf-8");
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
		//DB
		//MemberDAO memberDAO = new MemberDAO();	// 생성
		int su = memberService.write(memberDTO);	// 호출
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("write.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/member/loginForm.do")
	public String loginForm() {
		return "loginForm.jsp";
	}

	@RequestMapping(value="/member/login.do")
	public ModelAndView login(HttpServletRequest request) {
		//데이터 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		String name = memberService.login(id, pwd);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();		
		if(name == null) { 	
			modelAndView.setViewName("loginFail.jsp");
		} else { 			
			/* 세션를 이용한 데이터 공유 */		
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			modelAndView.setViewName("loginOk.jsp");
		} 
		return modelAndView;
	}
	
	@RequestMapping(value="/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		//데이터
		String id = request.getParameter("id");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberService.isExistId(id);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("checkId.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		//세션 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		
		session.invalidate();			// 무효화 : 모두 지우기
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logout.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		//MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberService.getMember(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberDTO", memberDTO);
		modelAndView.setViewName("modifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modify.do")
	public ModelAndView mpdify(HttpServletRequest request) throws IOException {
		//데이터
		request.setCharacterEncoding("utf-8");
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
		//DB
		//MemberDAO memberDAO = new MemberDAO();
		int su = memberService.modify(memberDTO);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su" , su);
		modelAndView.setViewName("modify.jsp");
		return modelAndView;
	}
}

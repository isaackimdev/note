package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;

public class LogoutProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션 사용하기 위해 객체 선언
		HttpSession session = request.getSession();
		
		// 세션 삭제
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		// 무효화 : 모두 지우기
		session.invalidate();
		
		request.setAttribute("req_page", "member/logout.jsp");
		return "index.jsp";
	}

}

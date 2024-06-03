package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.dao.MemberDAO;

public class LoginProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 읽어 오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		
		// Java에서의 세션 처리 
		HttpSession session = request.getSession();
		
		// 페이지 이동
		if(name == null ) {	
			request.setAttribute("req_page", "member/loginFail.jsp");
		} else {
			
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			request.setAttribute("req_page", "member/loginOk.jsp");
		}
		
		return "index.jsp";
	}

}

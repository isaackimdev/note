package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.dao.MemberDAO;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		
		if(name == null) { 	
			// 페이지 이동
			request.setAttribute("req_page", "member/loginFail.jsp");
		} else { 
			HttpSession session = request.getSession();	// 클래스에서 세션 얻어오기 request.response 만 작동하기 때문에 http request로 얻어오기
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			request.setAttribute("req_page", "member/loginOk.jsp");	
			//response.sendRedirect("/17-imageboard/main/index.jsp?req=");
		} 
		return "index.jsp";
	}
	
}

package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.Action;

public class LoginFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("req_page", "member/loginForm.jsp");
		return "index.jsp";
	}

}

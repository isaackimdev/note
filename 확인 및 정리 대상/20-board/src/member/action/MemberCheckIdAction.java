package member.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.Action;
import member.dao.MemberDAO;

public class MemberCheckIdAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터
		String id = request.getParameter("id");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistId(id);	
		// 데이터 공유
		request.setAttribute("id", id);
		request.setAttribute("exist", exist);
		
		// 페이지 이동
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("member/checkIdResult.jsp");
		dispatcher.forward(request, response);
		
		return null;
	}

}

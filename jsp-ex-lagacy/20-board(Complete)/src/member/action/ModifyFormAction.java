package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class ModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션 선언
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("memId");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.getMember(id);
		
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("req_page", "member/modifyForm.jsp");
		
		return "index.jsp";
	}

}

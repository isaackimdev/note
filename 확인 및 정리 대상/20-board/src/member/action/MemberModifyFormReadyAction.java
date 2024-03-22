package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyFormReadyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// DB
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("memId");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.getMember(id);
		// 데이터 공유
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("req_page", "member/modifyForm.jsp");	
		// 페이지 이동
		return "index.jsp";
	}

}

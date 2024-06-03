package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.Action;

public class BoardDeleteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		request.setAttribute("board_num", board_num);
		request.setAttribute("page", page);
		request.setAttribute("req_page", "board/boardDelete.jsp");
		return "index.jsp";
	}

}










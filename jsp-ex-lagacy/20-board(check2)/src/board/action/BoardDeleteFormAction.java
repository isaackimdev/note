package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String page = request.getParameter("page");
		String board_num = request.getParameter("board_num");
		
		request.setAttribute("page", page);
		request.setAttribute("board_num", board_num);
		
		// return "/board/boardDelete.jsp"; ±‚¡∏
		return "/index.jsp?req=boardDelete";
		
		/*
		request.setAttribute("req_page", "board/boardDelete.jsp");
		//return "index.jsp";
		*/
	}

}

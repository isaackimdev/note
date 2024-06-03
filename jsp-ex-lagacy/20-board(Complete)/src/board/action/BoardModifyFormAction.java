package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = boardDAO.selectArticle(board_num);
		
		request.setAttribute("boardBean", boardBean);
		request.setAttribute("page", page);
		request.setAttribute("req_page", "board/boardModify.jsp");
		return "index.jsp";	
	}

}











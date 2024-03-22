package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// page와 board_num 읽기
		String page = request.getParameter("page");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = boardDAO.selectArticle(board_num);	// 모든 정보를 담아와서
		
		request.setAttribute("page", page);
		request.setAttribute("board_num", board_num);	// boardBean에 들어가 있어서 굳이 안보내도 문제되지 않음
		request.setAttribute("boardBean", boardBean);	// 모든 정보 넘김
		
		//return "/board/boardModify.jsp"; 기존
		return "/index.jsp?req=boardModify";
		
		/*
		request.setAttribute("req_page", "board/boardModify.jsp");
		//return "index.jsp";
		*/
	}

}

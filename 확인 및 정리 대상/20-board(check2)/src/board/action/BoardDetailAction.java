package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
				
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateReadCount(board_num);						// 조회수 증가
		BoardBean boardBean = boardDAO.selectArticle(board_num);	// 데이터 보기
		
		request.setAttribute("page", page);
		request.setAttribute("boardBean", boardBean);
		
		// String forward = "/board/boardView.jsp"; 기존
		String forward = "/index.jsp?req=boardView";
		return forward;
	}

}

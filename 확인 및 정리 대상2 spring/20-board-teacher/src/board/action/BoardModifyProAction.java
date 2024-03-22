package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String pass = request.getParameter("board_pass");
		
		BoardBean boardBean = new BoardBean();
		BoardDAO boardDAO = new BoardDAO();
		boolean isRightUser = boardDAO.isArticleBoardWriter(board_num, pass);
		int updateCount = 0;
		String forward = null;
		
		if(isRightUser) {
			boardBean.setBoard_num(board_num); 
			boardBean.setBoard_subject(request.getParameter("board_subject")); 
			boardBean.setBoard_content(request.getParameter("board_content")); 
			updateCount = boardDAO.updateArticle(boardBean);
			
			if(updateCount == 0) {	// err_no = 1 => 수정실패
				forward = "boardModifyFail.do?board_num=" + board_num + "&err_no=1";
			} else {
				forward = "boardDetail.do?board_num=" + board_num;
			}
		} else {	// err_no =2 => 수정할 권한이 없슴.
			forward = "boardModifyFail.do?board_num=" + board_num + "&err_no=2";
		}
		
		request.setAttribute("page", page);		
		
		return forward;
	}

}

















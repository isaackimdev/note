package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forward = null;
		int page = Integer.parseInt(request.getParameter("page"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_pass = request.getParameter("board_pass");		
		
		boolean passCheck = false;
		
		BoardDAO boardDAO = new BoardDAO();
		passCheck = boardDAO.deleteArticleCheck(board_pass, board_num);
		
		if(passCheck == true) {
			int deleteCount = boardDAO.deleteArticle(board_num);
			if(deleteCount == 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패');");
				out.println("history.back();");
				out.println();
				out.println("</script>");
			} else {
				forward = "boardList.do?page="+page;
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println();
			out.println("</script>");
		}
		//forward ="boardList.do?page=" + page;
		return forward;
		
	}

}

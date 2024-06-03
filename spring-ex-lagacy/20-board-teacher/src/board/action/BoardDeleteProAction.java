package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pw = request.getParameter("pw");
		
		BoardDAO boardDAO = new BoardDAO();
		boolean isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pw);
		
		if(isArticleWriter) {
			int deleteCount = boardDAO.deleteArticle(board_num);
			if(deleteCount == 0) {
				System.out.println("test");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패');");
				out.println("history.back();");
				out.println();
				out.println("</script>");
			} else {
				forward = "boardList.do?page=" + page;
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
		
		return forward;
	}

}









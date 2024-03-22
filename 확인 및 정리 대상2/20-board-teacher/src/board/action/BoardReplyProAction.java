package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String forward = null;
		int page = Integer.parseInt(request.getParameter("page"));
		BoardBean boardBean = new BoardBean();
		boardBean.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		boardBean.setBoard_name(request.getParameter("board_name"));
		boardBean.setBoard_pass(request.getParameter("board_pass"));
		boardBean.setBoard_subject(request.getParameter("board_subject"));
		boardBean.setBoard_content(request.getParameter("board_content"));
		boardBean.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		boardBean.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		boardBean.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		
		BoardDAO boardDAO = new BoardDAO();
		int insertCount = 0;
		insertCount = boardDAO.insertReplyArticle(boardBean);
		
		if(insertCount > 0) {
			forward = "boardList.do?page=" + page;
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답장 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}











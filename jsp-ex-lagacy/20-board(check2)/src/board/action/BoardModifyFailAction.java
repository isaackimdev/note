package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyFailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		// err_no = 1 : 수정 실패
		// err_np = 2 : 수정할 권한이 없음.
		int err_no = Integer.parseInt(request.getParameter("err_no"));
		int page = Integer.parseInt((String)request.getAttribute("page"));
		
		request.setAttribute("board_num", board_num);
		request.setAttribute("err_no", err_no);
		request.setAttribute("page", page);		
		
		return "/board/boardModifyFail.jsp;
		
		*/
		
		//return "/board/boardModifyFail.jsp"; 기존
		return "/index.jsp?req=boardModifyFail";
		
		/*
		request.setAttribute("req_page", "board/boardModifyFail.jsp");
		//return "index.jsp";
		*/
	}

}

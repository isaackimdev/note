package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forward = "/board/boardList.jsp";	// 목록 보이기 jsp파일 
		return forward;								// 이동할 경로 return;
	}

}

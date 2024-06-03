package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.bean.PageInfo;
import board.dao.BoardDAO;

public class BoardListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardBean> list = null;
		int page = 1;
		int limit = 10; 	// 목록의 갯수 
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int endNum = page * limit;				// 1*10 = 10;
		int startNum = endNum - (limit - 1); 	// 10 - (10-1) = 1
		
		BoardDAO boardDAO = new BoardDAO();
		list = boardDAO.selectArticleList(startNum, endNum);
		// 총 리스트 수를 받아옴.
		int listCount = boardDAO.selectListCount();
		// 총 페이지 수.
		int maxPage = (listCount + limit - 1) / limit;	// (총 리스트 수 + 9 ) / 10
		// 현재 페이지에 보여줄 싲가 페이지 수
		int startPage = (page - 1)/3*3 + 1;	// 3개씩 보여줄 것이기 때문에 3으로 나눠 줌
		// 현재 페이지에 보여줄 마지막 페이지 수 
		int endPage = startPage + 2;
		if (endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);	// 총 리스트 수
		pageInfo.setMaxPage(maxPage);		// 총 페이지 수
		pageInfo.setPage(page);				// 현재 페이지
		pageInfo.setStartPage(startPage);	// 시작 페이지
		pageInfo.setEndPage(endPage);		// 끝 페이지
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		
		// String forward = "/board/boardList.jsp"; 기존
		String forward ="/index.jsp?req=boardList";
		return forward;

	}	
}






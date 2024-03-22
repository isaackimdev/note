package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		// 1. 사용자 입력 정보 추출 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = 1; // Integer.parseInt(request.getParameter("pg"));
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 2. DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		int su = boardDAO.boardDelete(seq);
		// 3. 화면 네비게이션
		request.setAttribute("su", su);
		request.setAttribute("pg", pg);
		return "boardDelete";
	}

}

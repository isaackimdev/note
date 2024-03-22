package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회");
		// 1. 사용자 입력 정보 추출 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		// 조회수 증가
		boardDAO.updateHit(seq);
		// 상세보기
		BoardDTO boardDTO = boardDAO.boardView(seq);
		// 3. 검색 결과를 request에 저장하고 상세 화면으로 이동한다.
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		return "boardView";
	}
	

}

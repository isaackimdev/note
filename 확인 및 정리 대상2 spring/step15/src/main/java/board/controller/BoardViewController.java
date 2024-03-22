package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardViewController {

	@RequestMapping(value="/board/boardView.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
//		request.setAttribute("boardDTO", boardDTO);
//		request.setAttribute("seq", seq);
//		request.setAttribute("pg", pg);
//		return "boardView";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;	
	}
}

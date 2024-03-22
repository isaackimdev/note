package board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 처리");
		// 1. 사용자 입력 정보 추출 (data)
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리 
		// DB - 1페이지당 5개씩
		int endNum = pg * 5 ;		// 5, 10, 15....
		int startNum = endNum - 4 ; // 1, 6, 11....
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> list = boardDAO.boardList(startNum, endNum);
		// 페이징 처리
		int totalA = boardDAO.getTotalA(); 	// 총글 수
		int totalP = (totalA + 4)/5;		// 총페이지 수
		// 페이징 3개씩 보여주기
		int startPage = (pg-1)/3*3+1;	// 1, 4, 7
		int endPage = startPage + 2;	// 3, 6, 9
		if(endPage > totalP) endPage = totalP;
		// 3. 검색 결과를 request에 저장하고 목록 화면으로 이동한다.
//		request.setAttribute("list", list);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
//		request.setAttribute("totalP", totalP );
//		request.setAttribute("pg", pg);
//		return "boardList";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP );
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}

}

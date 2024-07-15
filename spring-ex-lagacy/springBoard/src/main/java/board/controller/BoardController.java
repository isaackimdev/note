package board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 매개 변수 DI
	@RequestMapping(value="/board/boardList")	
	public ModelAndView boardList(HttpServletRequest request) {
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB - 1페이지당 5개씩
		// pg=1 rn>=1 and rn<=5
		// pg=2 rn>=6 and rn<=10
		// pg=3 rn>=11 and rn<=15
		int endNum = pg * 5 ;		// 5, 10, 15....
		int startNum = endNum - 4 ; // 1, 6, 11....
		//BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> list = boardService.boardList(startNum, endNum);
		// 페이징 처리
		// 총글수 : 12
		// 총페이지수 : 3			[1][2][3]		=> (총글수+4)/5
					
		// 총글수 : 23
		// 총페이지수 : 5			[1][2][3][4][5]	
					
		// 총글수 : 25
		// 총페이지수 : 5			[1][2][3][4][5]		
		int totalA = boardService.getTotalA(); 	// 총글 수
		int totalP = (totalA + 4)/5;		// 총페이지 수
		
		// 페이징 3개씩 보여주기
		// 3블럭
		//			[1][2][3][다음]
		//   [이전][4][5][6][다음]
		//   [이전][7][8]
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
		modelAndView.setViewName("board/boardList");
		return modelAndView;
	}
	
	// 글 상세보기
	@RequestMapping(value="/board/boardView")
	public ModelAndView boardView(HttpServletRequest request) {

		// 1. 사용자 입력 정보 추출 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
//		BoardDAO boardDAO = new BoardDAO();
		// 조회수 증가
		boardService.updateHis(seq);
		// 상세보기
		BoardDTO boardDTO = boardService.boardView(seq);
		// 3. 검색 결과를 request에 저장하고 상세 화면으로 이동한다.
//		request.setAttribute("boardDTO", boardDTO);
//		request.setAttribute("seq", seq);
//		request.setAttribute("pg", pg);
//		return "boardView";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("board/boardView");
		return modelAndView;	
	}
	
	@RequestMapping(value="/board/boardWriteForm")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) {
		// return "boardWriteForm";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardWriteForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		// 2. DB 연동 처리
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardWrite(boardDTO);
		// 3. 화면 네비게이션
		//request.setAttribute("su", su);
		//return "boardWrite";	// 	'./' 현재 폴더를 나타낸다.
								// ./boardWrite.jsp => ViewResolver를 통해서 완성
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("board/boardWrite");
		return modelAndView;
	}
	
	// 게시글 삭제
	@RequestMapping(value="/board/boardDelete")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) {

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = 1; // Integer.parseInt(request.getParameter("pg"));
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 2. DB 연동 처리
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);
		// 3. 화면 네비게이션
//		request.setAttribute("su", su);
//		request.setAttribute("pg", pg);
//		return "boardDelete";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("board/boardDelete");
		return modelAndView;
	}

	// 게시글 수정하기
	@RequestMapping(value="/board/boardModifyForm")
	public ModelAndView updateBoard(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		BoardDTO boardDTO = boardService.boardView(seq);	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.setViewName("boardModifyForm.jsp");
		return modelAndView;
	}
		
	@RequestMapping(value="/board/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request) throws IOException {
		System.out.println("모디파이");
		request.setCharacterEncoding("utf-8");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardModify(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardModify.jsp");
		return modelAndView;
	}


}


























package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB - 1페이지당 5개씩
		// pg=1 rn>=1 and rn<=5
		// pg=2 rn>=6 and rn<=10
		// pg=3 rn>=11 and rn<=15
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) boardService.boardList(startNum, endNum);
		
		// 페이징 처리
		// 총글수 : 12
		// 총페이지수 : 3			[1][2][3]		=> (총글수+4)/5
					
		// 총글수 : 23
		// 총페이지수 : 5			[1][2][3][4][5]	
					
		// 총글수 : 25
		// 총페이지수 : 5			[1][2][3][4][5]		
		int totalA = boardService.getTotalA();	// 총글수 (Total Article number)
		int totalP = (totalA+4) / 5;		// 총페이지수

		// 3블럭
		//			[1][2][3][다음]
		//   [이전][4][5][6][다음]
		//   [이전][7][8]
		int startPage = (pg-1)/3*3 + 1;	//(2-1)/3*3 + 1 = 1
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("display", "../board/boardList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("../main/index.jsp?req=boardList");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//BoardDAO boardDAO = new BoardDAO();
		boardService.updateHit(seq); 		// 조회수 증가
		BoardDTO boardDTO = boardService.boardView(seq);
	
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("display", "../board/boardView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("../main/index.jsp?req=boardView");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request) {
		System.out.println("게시글 수정 폼 처리");
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// Form에 기존 내용을 표시하기 위해, 다시 DB 데이터 얻어오기
		//BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardService.boardView(seq);	
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("display", "../board/boardModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("../main/index.jsp?req=boardModifyForm");
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
		modelAndView.addObject("display", "../board/boardModify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardModify.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardDelete.do")	
	public ModelAndView boardDelete(HttpServletRequest request) {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		//DB - delete
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../board/boardDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;

	}
	
	@RequestMapping(value="/board/boardWriteForm.do")	
	public ModelAndView boardWriteForm() {
		//return "../main/index.jsp?req=boardWriteForm";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../board/boardWriteForm.jsp" );
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite.do")	
	public ModelAndView boardWrite(HttpServletRequest request) throws IOException {
		//데이터베이스에 한글이 깨지지 않도록 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		//데이터
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		// 데이터 지정
		// 데이터의 개수가 많기 때문에 자바빈즈 클래스에 담아서 전달
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardWrite(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../board/boardWrite.jsp" );
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;

	}
	
}

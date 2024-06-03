package board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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
	public ModelAndView boardList(HttpServletRequest request) throws Exception {
		System.out.println("글 목록 처리");
		
		// 1. 사용자 입력 정보 추출
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리			
		// 페이징 처리
		// 총글수 : 12
		// 총페이지수 : 3			[1][2][3]		=> (총글수+4)/5
				
		// 총글수 : 23
		// 총페이지수 : 5			[1][2][3][4][5]	
				
		// 총글수 : 25
		// 총페이지수 : 5			[1][2][3][4][5]		
		int totalA = boardService.getTotalA();	// 총글수 (Total Article number)
		int totalP = (totalA+4) / 5;				// 총페이지수

		// 3블럭
		//			[1][2][3][다음]
		//   [이전][4][5][6][다음]
		//   [이전][7][8]
		int startPage = (pg-1)/3*3+1;	// (2-1)/3*3+1 = 1
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;	
							
		// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardListJson.do")
	public ModelAndView boardListJson(HttpServletRequest request) throws Exception {
		System.out.println("글 목록 처리");		
		// 1. 사용자 입력 정보 추출
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리			
		int endNum = pg*5;
		int startNum = endNum-4;
		
		ArrayList<BoardDTO> list = boardService.boardList(startNum, endNum);
		// JSON으로 결과값 반환
		String rt = null;
		int total = list.size();	// 조회된 데이터 수
		if(total > 0 ) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		JSONObject json = new JSONObject();	// 첫번째 중괄호
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray items = new JSONArray();
			for(int i=0; i<list.size(); i++) {
				BoardDTO boardDTO = list.get(i);
				JSONObject item = new JSONObject();
				item.put("seq", boardDTO.getSeq());
				item.put("id", boardDTO.getId());
				item.put("name", boardDTO.getName());
				item.put("subject", boardDTO.getSubject());
				item.put("content", boardDTO.getContent());
				item.put("hit", boardDTO.getHit());
				item.put("logtime", boardDTO.getLogtime());
				
				items.put(i, item);	// JSONArray에 추가
			}
			
			json.put("items", items);
		}
		System.out.println(json);
		// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("json", json);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardListJson.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) throws Exception {
		System.out.println("글 상세 조회 처리");	
		
		// 1. 검색할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리								
		//BoardDAO boardDAO = new BoardDAO();
		
		boardService.updateHis(seq); 	//조회수 증가
		BoardDTO boardDTO = boardService.boardView(seq);					
		// 3. 검색 결과를 세션에 저장하고 상세 화면으로 이동한다.	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request) {
		System.out.println("글 입력 폼 처리");
		// 1. 화면 네비게이션	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) throws Exception {
		System.out.println("글 등록 처리");
		
		// 1. 사용자 입력 정보 추출				
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
				
		// 2. DB 연동 처리
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(name);
		boardDTO.setId(id);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
				
		//BoardDAO boardDAO = new BoardDAO(); 
		int su = boardService.boardWrite(boardDTO);
				
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardWrite.jsp");		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) throws Exception {
		System.out.println("글 삭제 처리");
		
		// 1. 사용자 입력 정보 추출	
		int seq = Integer.parseInt(request.getParameter("seq"));
				
		// 2. DB 연동 처리
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);			
		// 3. 화면 네비게이션		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;		
	}
}

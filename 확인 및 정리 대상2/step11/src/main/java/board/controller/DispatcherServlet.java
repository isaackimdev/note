package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	// get, post 어떤 방식으로 오든 process함수를 호출하게 되어 있음.
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// uri = /step11/member/login.do
		System.out.println("uri = " + uri);
		// path = /login.do
		System.out.println("path = " + path);
		
		String viewPage = "";	// jsp 파일이름 저장
		
		// 2. 클라이언트의 요청 path에 따라 분기처리
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			// 2. DB 연동 처리
			MemberDAO memberDAO = new MemberDAO();
			String name = memberDAO.login(id, pwd);
			// 3. 화면 네비게이션
			if(name == null) {	// 로그인 실패
				// response.sendRedirect("loginForm.jsp");
				viewPage ="loginForm.jsp";
			}	else {		// 로그인 성공
				HttpSession session = request.getSession();	// 세션 얻어오기
				session.setAttribute("memId", id);
				session.setAttribute("memName", name);
				// forward 방식으로 보내면 폴더명이 안바뀜
				// 다른 폴더 일때는 sendRedirect가 편함..
				response.sendRedirect("../board/boardList.do?pg=1");
				return;	// 더이상 진행을 막음
			}
			
		} else if(path.equals("/boardWriteForm.do")) {
			viewPage = "boardWriteForm.jsp";
		} else if(path.equals("/boardWrite.do")) {
			System.out.println("글 등록 처리");
			// 1. 사용자 입력 정보 추출
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String id = (String)session.getAttribute("memId");
			String name = (String)session.getAttribute("memName");
			// 2. DB 연동 처리
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setName(name);
			boardDTO.setId(id);
			boardDTO.setSubject(subject);
			boardDTO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			int su = boardDAO.boardWrite(boardDTO);
			// 3. 화면 네비게이션
			request.setAttribute("su", su);
			viewPage ="boardWrite.jsp";
		} else if(path.equals("/boardDelete.do")) {
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
			viewPage="boardDelete.jsp";
		} else if(path.equals("/boardView.do")) {
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
			viewPage = "boardView.jsp";
		} else if(path.equals("/boardList.do")) {
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
			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
			request.setAttribute("list", list);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("totalP", totalP );
			request.setAttribute("pg", pg);
			viewPage = "boardList.jsp";
		}
		// 3. page 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}

package score.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.RegexHelper;
import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet2() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//uri = /step11_test1_1/score/scoreWrite.do
		System.out.println("uri = " + uri);
		//path = /scoreWrite.do
		System.out.println("path = " + path);
		
		String viewPage ="";
		
		// 2. 클라이언트의 요청 path에 따라 분기처리
		if(path.equals("/scoreWriteForm.do")) {
			viewPage = "scoreWriteForm.jsp";
		} else if(path.equals("/scoreWrite.do")) {
			System.out.println("성적등록처리");
			// 데이터 처리
			request.setCharacterEncoding("UTF-8");
			int insertCount = 0 ;
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setStudNo(request.getParameter("studNo"));
			scoreDTO.setName(request.getParameter("name"));
			
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int mat = Integer.parseInt(request.getParameter("mat"));
			int tot = kor + eng + mat;
			double avg = (double)tot / 3;
			
			scoreDTO.setKor(kor);
			scoreDTO.setEng(eng);
			scoreDTO.setMat(mat);
			scoreDTO.setTot(tot);
			scoreDTO.setAvg(avg);
			// DB
			ScoreDAO dao = new ScoreDAO();
			insertCount = dao.insertScore(scoreDTO);
			
			request.setAttribute("insertCount" , insertCount);
			
			viewPage = "scoreWrite.jsp";
		} else if(path.equals("/scoreList.do")) {
			System.out.println("성적목록처리");
			ArrayList<ScoreDTO> list = null;
			int pg = 1;
			int limit = 5;
			String str = request.getParameter("pg");
			// 문자열을 숫자로 변환할 때
			// 1. null 확인 2. 숫자만으로 구성되었는지 => ★정규표현식으로 검사★		
			if(RegexHelper.getInstance().isNum(str)) {
				pg = Integer.parseInt(str);
			}
			int endNum = pg * limit;				// 5, 10, 15..
			int startNum = endNum - (limit - 1);	// 1, 6, 11..
			
			ScoreDAO scoreDAO = new ScoreDAO();
			list = (ArrayList<ScoreDTO>)scoreDAO.getScoreList(startNum, endNum);	// 값들을 list에 담는다. 다섯개씩
			
			int listCount = scoreDAO.selectListCount();	// 총 갯수를 가지고 온다.
			
			int maxPage = (listCount + limit - 1 ) / limit;		// (26 + 5 - 1) / 5
			int startPage = (pg-1)/3*3+1;
			int endPage = startPage + 2;
			if(endPage > maxPage) endPage = maxPage;
			// 3. 내용공유 및 페이지 이동
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("pg", pg);
			
			
			viewPage = "scoreList.jsp";
		} else if(path.equals("/scoreView.do")) {
			System.out.println("성적상세보기처리");
			
			// 1. 검색할 게시글 번호 추출 _ 데이터
			request.setCharacterEncoding("utf-8");
			String studNo = request.getParameter("studNo");
			String str_pg = request.getParameter("pg");
			int pg = 1;
			if(RegexHelper.getInstance().isNum(str_pg)) {	// 정규표현식 사용
				pg = Integer.parseInt(str_pg);
			}
			// 2. DB 연동 처리
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setStudNo(studNo);
			scoreDTO = scoreDAO.getScore(scoreDTO);
			// 3. 검색 결과를 requsest에 저장하고 상세 화면으로 이동한다.
			request.setAttribute("scoreDTO", scoreDTO);
			request.setAttribute("studNo", studNo);
			request.setAttribute("pg", pg);
			
			viewPage = "scoreView.jsp";
		} else if(path.equals("/scoreDelete.do")) {
			System.out.println("성적삭제처리");
			// 데이터
			request.setCharacterEncoding("utf-8");
			String studNo = request.getParameter("studNo");
			int pg = Integer.parseInt(request.getParameter("pg"));
			
			// DB
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setStudNo(studNo);
			int su = scoreDAO.deleteScore(scoreDTO);
			// 
			request.setAttribute("su", su);
			request.setAttribute("pg", pg);
			
			
			viewPage = "scoreDelete.jsp";
		}  
		
		
		
		
		
		// 3. page이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}

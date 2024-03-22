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
		
		// uri = /step11_test1/*.do
		System.out.println("uri = " + uri);
		// path = /*.do
		System.out.println("path = " + path);
		
		String viewPage = "";	// jsp 파일이름 저장
		
		// 2. 클라이언트의 요청 path에 따라 분기처리
		if(path.equals("/scoreWrite.do")) {
			System.out.println("[servlet]성적 등록 처리");
			// 1. 사용자 입력 정보 추출
			// 2. DB 연동 처리
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
			
			request.setAttribute("insertCount", insertCount);
			// 3. 화면 네비게이션
			//response.sendRedirect("../score/scoreWriteList.do?pg=1");			
			viewPage = "scoreWrite.jsp";	
		} else if (path.equals("/scoreWriteForm.do")) {
			System.out.println("[servlet] 성적 등록 폼으로 이동 처리");
			viewPage = "scoreWriteForm.jsp";
		} else if (path.equals("/scoreDelete.do")) {
			System.out.println("[servlet] 성적 삭제 처리");
			// 1. 데이터 처리
			request.setCharacterEncoding("utf-8");
			String studNo = request.getParameter("studNo");
			int pg = Integer.parseInt(request.getParameter("pg"));
			
			// 2. DB 연동 처리
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setStudNo(studNo);
			int su = scoreDAO.deleteScore(scoreDTO);
			
			request.setAttribute("su", su);
			request.setAttribute("pg", pg);
			
			viewPage = "scoreDelete.jsp";
		} else if (path.equals("/scoreList.do")) {
			System.out.println("[servlet] 성적 목록 조회");
			// 1. 데이터 처리
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
			
			request.setAttribute("list", list);
			request.setAttribute("pg", pg);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			
			viewPage = "scoreList.jsp";
		} else if (path.equals("/scoreView.do")) {
			System.out.println("[servlet] 성적 상세 조회");
			// 데이터
			request.setCharacterEncoding("utf-8");
			String studNo = request.getParameter("studNo");
			String str_pg = request.getParameter("pg");
			int pg = 1;
			if(RegexHelper.getInstance().isNum(str_pg)) {	// 정규표현식 사용
				pg = Integer.parseInt(str_pg);
			}
			// DB
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setStudNo(studNo);
			scoreDTO = scoreDAO.getScore(scoreDTO);
			
			request.setAttribute("scoreDTO", scoreDTO);
			request.setAttribute("studNo", studNo);
			request.setAttribute("pg", pg);
			
			viewPage = "scoreView.jsp";
		}
		// 3. page 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	} // process()
}

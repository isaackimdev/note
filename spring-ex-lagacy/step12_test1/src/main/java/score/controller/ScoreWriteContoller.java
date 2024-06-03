package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreWriteContoller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 성적 등록 처리
		System.out.println("성적 등록 처리");
		// 1. 사용자 입력 정보 추출
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		// 2. DB 연동 처리
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		scoreDTO.setName(name);
		scoreDTO.setKor(kor);
		scoreDTO.setEng(eng);
		scoreDTO.setMat(mat);
		int tot = kor + eng + mat;
		scoreDTO.setTot(tot);
		scoreDTO.setAvg((double)tot/3);
		
		ScoreDAO scoreDAO = new ScoreDAO();
		int insertCount = scoreDAO.insertScore(scoreDTO);
		// 3. 화면 네비게이션
		request.setAttribute("insertCount", insertCount);
		return "scoreWrite";	// "./" 현재 폴더를 나타냄
								// ./scoreWrite.jsp => viewResolver를 통해서 완성
	}

}

package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적 상세보기 조회");
		// 1. 사용자 입력 정보 추출
		String studNo = request.getParameter("studNo");
		int pg =  Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		ScoreDAO scoreDAO = new ScoreDAO();
		
		
		// 상세보기
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		
		ScoreDTO vo = scoreDAO.getScore(scoreDTO);
		
		// 3. 검색 결과를 request에 저장하고 상세 화면으로 이동한다.
		request.setAttribute("scoreDTO", vo);
		request.setAttribute("studNo", studNo);
		request.setAttribute("pg", pg);
		return "scoreView";
	}

}

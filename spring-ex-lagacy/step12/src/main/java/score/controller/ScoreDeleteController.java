package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 1. 사용자 입력 정보 추출
		String studNo = request.getParameter("studNo");
		int pg = 1; // Integer.parseInt(request.getParameter("pg"));
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		// 2. DB 연동 처리
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		int su = scoreDAO.deleteScore(scoreDTO);
		
		request.setAttribute("su", su);
		request.setAttribute("pg", pg);
	
		return "scoreDelete";
	}

}

package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import helper.RegexHelper;
import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적상세보기처리");
		
		// 1. 검색할 게시글 번호 추출 _ 데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
//		request.setAttribute("scoreDTO", scoreDTO);
//		request.setAttribute("studNo", studNo);
//		request.setAttribute("pg", pg);
//		
//		return "scoreView";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("scoreDTO", scoreDTO);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreView.jsp");
		return modelAndView;
		
	}

}

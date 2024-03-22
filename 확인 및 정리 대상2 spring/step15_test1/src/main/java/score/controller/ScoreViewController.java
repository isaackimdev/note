package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreViewController {

	@RequestMapping(value="/score/scoreView.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
//		request.setAttribute("scoreDTO", vo);
//		request.setAttribute("studNo", studNo);
//		request.setAttribute("pg", pg);
//		return "scoreView";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("scoreDTO", vo);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreView.jsp");
		return modelAndView;
	}

}

package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreModifyFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("수정 폼 화면 처리");
		// 1. 전달된 정보 추출
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// view에서 보내는 자료 [페이지 : pg / 학번 : studNo]
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 2. DB 연동처리
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		ScoreDTO vo = scoreDAO.getScore(scoreDTO);
		// 3. 검색결과를 ModelAndView에 저장하고 목록 화면으로 이동한다.		//System.out.println(vo.toString());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("vo", vo);	// 선생님은 DTO를 재활용 함.
		modelAndView.setViewName("scoreModifyForm.jsp");
		return modelAndView;
	}
}

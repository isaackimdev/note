package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreModifyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("수정 데이터 처리");
		// 1. 전달된 정보 추출
		request.setCharacterEncoding("UTF-8");
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		// 2. DB 연동 처리
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		scoreDTO.setName(name);
		scoreDTO.setKor(kor);
		scoreDTO.setEng(eng);
		scoreDTO.setMat(mat);
		scoreDTO.setTot(tot);
		scoreDTO.setAvg(avg);
		ScoreDAO scoreDAO = new ScoreDAO();
		int updateCount = scoreDAO.updateScore(scoreDTO);	// 선생님 변수 result
		// 3. 처리 결과를 ModelAndView에 저장하고 목록 화면으로 이동한다.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("updateCount", updateCount);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreModify.jsp");
		return modelAndView;
	}
}

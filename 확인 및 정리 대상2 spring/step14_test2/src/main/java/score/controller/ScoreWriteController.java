package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreWriteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적등록처리");
		// 데이터 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
		
		// 데이터 공유 및 페이지 이동 처리
		//request.setAttribute("insertCount" , insertCount);
		//return "scoreWrite";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("insertCount" , insertCount);	// DATA 담는 방법
		modelAndView.setViewName("scoreWrite.jsp");	// view page 를 String값으로 담음
		return modelAndView; 
	}

}

/**
* 모든 controller 부분이 수정이 된다.
* 함수 리턴값은 String  ==>  ModelAndView 로 수정됨
* 반환값 ㅜ분도 수정됨
* Controller 부분도 Spring에서 상속받는다.
*
*
*/
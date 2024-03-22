package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreWriteFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//return "scoreWriteForm";	// ./scoreWriteForm.jsp
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreWriteForm.jsp");
		return modelAndView;		//	./scoreWriteForm.jsp
	
		
		
	}

}

/**
 * 반환값 String에서 MedelAndView 로 수정
 * Controller는 Spring framework에서 제공하는 controller를 import하여
 * 사용 함. 이 때 리턴값 변경을 요구하게 됩니다.
 * 
 */

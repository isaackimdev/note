package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardWriteFormController {

	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 입력 폼 처리");
		// return "boardWriteForm";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
}

package guestbook.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guestbook.bean.GuestbookDTO;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookService gusetbookService;
	
	
	@RequestMapping("guestbook/guestbookWriteForm")
	public String guestbookWriteForm() {
		System.out.println("글 쓰기 폼 처리");
		return "../main/main.jsp?req=guestWriteForm";
	}
	
	@RequestMapping("guestbook/guestbookWrite")
	public ModelAndView guestbookWrite(HttpServletRequest request) throws Exception {
		System.out.println("방명록 데이터 등록 처리");
		// 데이터 처리
		request.setCharacterEncoding("UTF-8");
		String guest_writer = request.getParameter("guest_writer");
		String guest_email = request.getParameter("guest_email");
		String guest_subject = request.getParameter("guest_subject");
		String guest_content = request.getParameter("guest_content");
		
		// 데이터 저장
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setGuest_writer(guest_writer);
		guestbookDTO.setGuest_email(guest_email);
		guestbookDTO.setGuest_subject(guest_subject);
		guestbookDTO.setGuest_content(guest_content);
		
		guestbookDTO.toString();
		// DB
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		int su = gusetbookService.guestbookWrite(guestbookDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../main/main.jsp?req=guestbookWrite");
		return modelAndView;
	}
	
	@RequestMapping("guestbook/guestbookList")
	public ModelAndView guestbookList (HttpServletRequest request) throws Exception {
		System.out.println("목록 처리");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookDTO> list = gusetbookService.guestbookList(startNum, endNum);
		
		int totalA = gusetbookService.getTotalA();
		int totalP = (totalA+4) / 5;		// 총페이지수
		int startPage = (pg-1)/3*3 + 1;	//(2-1)/3*3 + 1 = 1
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("../main/main.jsp?req=guestbookList");
		return modelAndView;
	}
	
	
}

package guestbook.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@Controller
public class GuestbookController {

	@RequestMapping("guestbook/guestbookWriteForm")
	public String guestbookWriteForm() {
		System.out.println("글 쓰기 폼 처리");
		return "../main/main.jsp?req=guestWriteForm";
	}
	
	@RequestMapping("guestbook/guestbookWrite")
	public ModelAndView guestbookWrite(HttpServletRequest request) throws UnsupportedEncodingException {
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
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		int su = guestbookDAO.guestbookWrite(guestbookDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../main/main.jsp?req=guestbookWrite");
		return modelAndView;
	}
	
}

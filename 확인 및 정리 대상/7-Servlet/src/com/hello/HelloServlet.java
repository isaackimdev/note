package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

	@Override	// 확인용도... 서블릿 종료시 실행 
	public void destroy() {
		System.out.println("destroy()...");
	}

	@Override	// 확인용도... 서블릿 시작시에 실행
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...");
	}

	// 햔재 이 것은
	// <servlet 서블릿 = JSP>
	// 1. Data 처리 : 클라이언트에서 넘어온 data처리
	// 2. HTML 문서만들기 : 클라이언트로 응답으로 보내줄 문서
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 요청 , response 응답		
		System.out.println("doGet()...");
		// 이후의 문자열을 html로 인식해라 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세요 서블릿!!<br>");
		out.println("안녕하세요 서블릿!!<br>");	
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*
 *  < 이클립스 >
 *  1. 서버구동
 *  2. 웹브라우저 구동
 *  3. 웹브라우저 요청
 *  
 * */





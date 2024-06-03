package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HiServlet")
public class HiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HiServlet() {
        super();
    }

	@Override
	public void destroy() {
		System.out.println("서블릿 종료");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 시작");
	}

	/* 역할 */
	// 1. 클라이언트에서 넘어온 data처리 
	// 2. 클라이언트로 응답으로 보내줄 문서
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request는 요청, response는 응답을 뜻합니다.
		System.out.println("doGet() 실행");
		// 이후 응답할 문자열을 html문서로 인식할 것을 명령합니다.
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("Hi 서블릿!!<br>");
		out.println("안녕하세요 서블릿!!<br>");	
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

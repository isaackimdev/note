package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParamServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	// 톰캣서버가 doGet을 호출 함.
    // 호출할때 데이터를 넘어온 값을 request 객체로 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 톰켓서버가 만들어서 request / response 객체 생성하여 >> doGet에 전달
		// 넘어온 데이터는 request 객체에 저장
				
		// 1. 데이터
		String name = request.getParameter("name");
		String str_age = request.getParameter("age");
		// 모든 데이터는 문자열 String 타입으로 서버로 넘어 온다.
		int age = Integer.parseInt(str_age);
		// 2. 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(name + "님의 나이는" + age + "살 이므로, ");
		if(age>= 19) out.println("성인입니다.");
		else out.println("청소년입니다.");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

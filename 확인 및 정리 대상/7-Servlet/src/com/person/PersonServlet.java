package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// annotation 으로 등록하기 서블릿등록 두번째 방법
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonServlet() {
        super();
    }
    // 톰캣서버가 doGet을 호출 함.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 1. 데이터
		String name = request.getParameter("name");
		
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");

		String color = request.getParameter("color");
		String[] subject = request.getParameterValues("subject");
		
		// 2. 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		
		out.println("<style>");
		out.println("li { color: yellow; }");
		out.println("</style>");
		
		out.println("</head>");
		out.println("<body bgcolor="+ color + ">");
		out.println("<ul>");
		out.println("<li> 이름 : " + name + "</li>");
		out.println("<li> 성별 : ");
		if(gender.equals("m")) out.println("남자");
		else out.println("여자");
		out.println("</li>");
		out.println("<li> 취미 : ");
										// .length라는 배열의 길이 구하는 기능 함수를 쓰기 떄문에 예외를 잡아줘야 함..
		if(hobby != null) {				// error 중 500은 servlet 코드에서 에러발생 , 404는 파일이 없음
			for(int i =0 ; i < hobby.length; i++) {
				out.println(hobby[i]);	
			}
		}
		out.println("</li>");
		out.println("<li> 색깔 : " + color + "</li>");
		out.println("<li> 과목 : ");
		if(subject != null) {
			for(int i =0 ; i < subject.length; i++) {
				out.println(subject[i]);
			}
		}
		out.println("</li><br>");
		out.println("<a href='#' onclick=\"history.back(); return false;\">뒤로</a>");
		//out.println("<a href='javascript:history.go(-1)'>뒤로</a>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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

	@Override	// Ȯ�ο뵵... ������ ����� ���� 
	public void destroy() {
		System.out.println("destroy()...");
	}

	@Override	// Ȯ�ο뵵... ������ ���۽ÿ� ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...");
	}

	// �h�� �� ����
	// <servlet ������ = JSP>
	// 1. Data ó�� : Ŭ���̾�Ʈ���� �Ѿ�� dataó��
	// 2. HTML ��������� : Ŭ���̾�Ʈ�� �������� ������ ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request ��û , response ����		
		System.out.println("doGet()...");
		// ������ ���ڿ��� html�� �ν��ض� 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("�ȳ��ϼ��� ������!!<br>");
		out.println("�ȳ��ϼ��� ������!!<br>");	
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*
 *  < ��Ŭ���� >
 *  1. ��������
 *  2. �������� ����
 *  3. �������� ��û
 *  
 * */





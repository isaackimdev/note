package score.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    public DispatcherServlet() {
        super();
      }

    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// uri = /step12_test1_1/score/scoreWrite.do
		System.out.println("uri = " + uri);
		// path = /scoreWrite.do
		System.out.println("path = " + path);
		// 2. handlerMapping 클래스를 통해 path에 해당하는 Controller를 검색
		Controller controller = handlerMapping.getController(path);
		// 3. 검색된 Controller를 실행 (데이터 처리)
		String viewName = controller.handleRequest(request, response);
		// 4. ViewResolver 클래스를 통해 viewName에 해당하는 화면을 검색
		String view = viewResolver.getView(viewName);
		// 5. 검색된 화면으로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}



	/**
	* 순서
	* 
	* 
	* 
	* 
	* 
	* 
	*/

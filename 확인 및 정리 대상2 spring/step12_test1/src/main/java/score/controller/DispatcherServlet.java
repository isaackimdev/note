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
    // 생성자 다음으로, 서버가 구동될 때 생성됨
    
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");	// "./" 현재폴더를 의미
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
		System.out.println("uri = " + uri);
		System.out.println("path = " + path);
		// 2. HandlerMapping 클래스를 통해 path에 해당하는 Controller를 검색
		Controller controller = handlerMapping.getController(path);
		// 3. 검색된 Controller를 실행 (데이터 처리)
		String viewName = controller.handleRequest(request, response);
		// 4. ViewResolver 클래스를 통해 viewName에 해당하는 화면을 검색
		String view = null;	// JSP 파일 이름 저장
		if(viewName.contains(".do")) {
			view = viewName;
		} else {
			view = viewResolver.getView(viewName);
		}
		// 5. 검색된 화면으로 이동
		if(path.equals("/scoreWriteForm.do")) {	// 폴더가 다를 때
			response.sendRedirect(view);
		} else {							// 폴더가 같을 때
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		
	}
}

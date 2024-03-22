package board.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"*.do"},
		initParams = {
			@WebInitParam(name="propertyConfig", value="command.properties")
		}
	)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령어와 명령어 처리 클래스를 쌍으로 저장할 Map 클래스
    private Map<String, Object> commandMap = new HashMap<String, Object>();
    
    public BoardController() {
        super();
    }
    // 명령어와 명령어 처리클래스가 매핑되어 있는 properties 파일을 읽어서 
    // Map 클래스에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// initParams에서 propertyConfig의 값을 읽어옴
    	String propertyConfig = config.getInitParameter("propertyConfig");
    	// "/property" 폴더의 절대 경로를 구함
    	String realFolder = config.getServletContext().getRealPath("/property");
    	String realPath = realFolder + "/" + propertyConfig;
    	// 명령어와 처리 클래스의 매핑정보를 저장할 Properties 객체 생성
    	Properties properties = new Properties();
    	// 파일을 읽어올 IO 클래스
    	FileInputStream fis = null;
    	try {
    		// command.properties 파일 읽어오기
			fis = new FileInputStream(realPath);
			// command.properties 파일의 내용을 Properties 객체에 저장
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	// Set 객체의 iterator() 메소드를 사용해서 Iterator 객체를 얻어냄
    	Iterator<?> iterator = properties.keySet().iterator();
    	// Iterator 객체에 저장된 명령어와 명령어 처리 클래스를 Map 객체에 저장
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();	
    		String className = properties.getProperty(command);
    		// command = "/boardWriteForm.do"    		
    		// className = "board.action.BoardWriteFormAction"
    		try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// 1. 웹브라우저의 요청을 분석하고, 해당 요청의 처리를 수행할 model 실행
	// 2. 처리결과를 view에 보냄
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;	// jsp 파일의 이름
		Action action = null;
		// 요청정보확인
		// command = /boardWriteForm.do
		String command = request.getServletPath();
		// 요청작업처리
		action = (Action) commandMap.get(command);
		try {
			result = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 응답을 위한 view를 선택하고, forward 처리
		if(result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		}
	}
}









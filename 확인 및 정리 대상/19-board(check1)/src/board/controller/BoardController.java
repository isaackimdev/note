package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardListAction;
import board.action.BoardWriteProAction;

@WebServlet("*.do")	// annotation 으로 이 클래스를 등록,
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }
    // 1. 웹브라우저 요청 받기 (get 방식)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}	// 1. 웹브라우저 요청 받기  (post 방식)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 2. 요청 정보 확인
		String command = request.getServletPath();
		// command = /boardWriteForm.do
		System.out.println("command = " + command);	// 서블릿 경로 찾기
		// 3. 요청 작업 처리 (로직 처리)
		String forward = null;
		/** 막혔던 부분 start */
		Action action = null; // board.action package에 있는 우리가 만든 Action 을 만들어주어야 한다.
		/** 막혔던 부분 end */
		if(command.equals("/boardWriteForm.do")) {
			forward = "/board/boardWriteForm.jsp";
		
		/** 막혔던 부분 start */
		} else if (command.equals("/boardWritePro.do")) {	// 게시글 저장하기
			action = new BoardWriteProAction();	// 부모 기준으로 쓰는 것, 다형성
			// forward = "/board/boardList.jsp"; 기존에 내가 짠 코드
		} else if (command.equals("/boardList.do")) {	// 선생님이 짠 코드
			action = new BoardListAction();
		}
		
		/* 선생님이 짠 코드 */
		if (action != null) {
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/** 막혔던 부분 end */
		
		// 4. 응답을 위한 view를 선택하고, forward 처리
		if(forward != null) {	// 이방식으로 하면 보안에 좀 더 좋다, 요청하는 파일과 실제 보여주는 내용이 다르기 떄문에.
			/** null 이면 아무런 동작도 하지 않음 */
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}
}

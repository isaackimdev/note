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

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardController() {
        super();
    }
    // 1. 웹브라우저 요청 받기 (post/get 방식)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 2. 요청 정보 확인
		String command = request.getServletPath();
		// command = /boardWriteForm.do
		System.out.println("command = " + command);
		// 3. 요청 작업 처리 (로직 처리)
		String forward = null;
		Action action = null;
		if(command.equals("/boardWriteForm.do")) {
			forward = "/board/boardWriteForm.jsp";
		} else if(command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
		} else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
		}
		
		if(action != null) {
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 4. 응답을 위한 view를 선택하고, forward 처리
		if(forward != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}
}














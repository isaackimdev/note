package exam2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam2.message.Action;
import exam2.message.MessageGuestAction;
import exam2.message.MessageHostAction;
import exam2.message.MessageMismatchAction;
import exam2.message.MessageNullAction;

@WebServlet("/MessageController2")
public class MessageController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MessageController2() {
        super();
    }
    // 1. 웹브라우저 요청 받기 (get 방식)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	// 1. 웹브라우저 요청 받기 (post 방식)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 선언
		String message = null;
		String view = null;
		// 2. 요청 정보 확인
		message = request.getParameter("message");
		// 3. 요청 작업 처리 (로직 처리)
		// 4. 요청 처리 결과를 request 객체에 저장
		Action action = null;
		if(message == null) {
			action = new MessageNullAction();
		} else if(message.equals("host")) {
			action = new MessageHostAction();
		} else if(message.equals("guest")) {
			action = new MessageGuestAction();
		} else {
			action = new MessageMismatchAction();
		}
		
		if(action != null) {
			try {
				view = action.process(request, response);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}		
		// 5. 응답을 위한 view를 선택하고, forward 처리
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}











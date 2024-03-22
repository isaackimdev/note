package exam4.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageGuestAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "홍길동 입니다.");
		return "messageView.jsp";
	}
}

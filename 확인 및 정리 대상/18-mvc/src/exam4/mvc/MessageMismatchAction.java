package exam4.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageMismatchAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "타입이 맞지 않습니다.");
		return "messageView.jsp";
	}
}

package exam3.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageNullAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "전달된 내용이 없습니다.");
		return "/exam3/messageView.jsp";
	}
}

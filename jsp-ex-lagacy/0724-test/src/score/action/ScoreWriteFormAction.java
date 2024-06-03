package score.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.controller.Action;

public class ScoreWriteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("req_page", "score/scoreWriteForm.jsp");
		return "index.jsp";
	}

}

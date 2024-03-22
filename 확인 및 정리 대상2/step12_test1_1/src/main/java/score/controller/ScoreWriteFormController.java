package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScoreWriteFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "scoreWriteForm";	// ./scoreWriteForm.jsp
	}

}

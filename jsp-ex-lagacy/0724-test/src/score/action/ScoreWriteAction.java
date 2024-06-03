package score.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.controller.Action;
import score.dao.ScoreDAO;

public class ScoreWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// data Ã³¸®
		request.setCharacterEncoding("UTF-8");
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setScore_num(Integer.parseInt(request.getParameter("score_num")));
		scoreDTO.setScore_name(request.getParameter("score_name"));
		scoreDTO.setScore_kor(Integer.parseInt(request.getParameter("score_kor")));
		scoreDTO.setScore_eng(Integer.parseInt(request.getParameter("score_eng")));
		scoreDTO.setScore_mat(Integer.parseInt(request.getParameter("score_mat")));
		scoreDTO.setScore_tot(scoreDTO.getScore_kor() + scoreDTO.getScore_eng() + scoreDTO.getScore_mat());
		scoreDTO.setScore_avg(scoreDTO.getScore_tot()/3);
		
		ScoreDAO scoreDAO = new ScoreDAO();
		int insertCount = scoreDAO.insertScore(scoreDTO);
		
		request.setAttribute("score_name", scoreDTO.getScore_name());
		request.setAttribute("insertCount", insertCount);
		request.setAttribute("req_page", "score/scoreWriteResult.jsp");
		
		return "index.jsp";
	}

}

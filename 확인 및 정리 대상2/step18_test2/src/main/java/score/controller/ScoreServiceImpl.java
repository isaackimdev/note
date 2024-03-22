package score.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired	// 생성자와 setter / getter 초기화 및 내부적으로 동작시킴
	private ScoreDAO scoreDAO;
	
	@Override
	public int insertScore(ScoreDTO scoreDTO) {
		return scoreDAO.insertScore(scoreDTO);
	}

	@Override
	public int updateScore(ScoreDTO scoreDTO) {
		return scoreDAO.updateScore(scoreDTO);
	}

	@Override
	public int deleteScore(ScoreDTO scoreDTO) {
		return scoreDAO.deleteScore(scoreDTO);
	}

	@Override
	public ScoreDTO getScore(ScoreDTO scoreDTO) {
		return scoreDAO.getScore(scoreDTO);
	}

	@Override
	public ArrayList<ScoreDTO> getScoreList(int startNum, int endNum) {
		return (ArrayList<ScoreDTO>)scoreDAO.getScoreList(startNum, endNum);
	}

	@Override
	public int selectListCount() {
		return scoreDAO.selectListCount();
	}

	

}

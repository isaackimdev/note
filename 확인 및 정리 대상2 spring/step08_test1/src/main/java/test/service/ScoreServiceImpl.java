package test.service;

import java.util.List;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

public class ScoreServiceImpl implements ScoreService{
	
	private ScoreDAOSpring scoreDAO;
	
	public ScoreDAOSpring getScoreDAO() {
		return scoreDAO;
	}
	public void setScoreDAO(ScoreDAOSpring scoreDAO) {
		this.scoreDAO = scoreDAO;
	}


	@Override
	public int insertScore(ScoreVO vo) {
		return scoreDAO.insertScore(vo);
	}

	@Override
	public int updateScore(ScoreVO vo) {
		return scoreDAO.updateScore(vo);
	}

	@Override
	public int deleteScore(ScoreVO vo) {
		return scoreDAO.deleteScore(vo);
	}

	@Override
	public ScoreVO getScore(ScoreVO vo) {
		return scoreDAO.getScore(vo);
	}

	@Override
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		return scoreDAO.getScoreList(vo);
	}

}

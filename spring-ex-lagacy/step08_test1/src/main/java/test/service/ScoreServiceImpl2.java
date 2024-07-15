package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;
@Service("scoreService")
public class ScoreServiceImpl2 implements ScoreService{

	@Autowired	// 만들어진걸 세팅만 해줌.. autowired로
	private ScoreDAOSpring scoreDAO;
	
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

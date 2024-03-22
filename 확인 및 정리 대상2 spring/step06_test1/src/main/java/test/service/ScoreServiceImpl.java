package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	// <property name="scoreDAO" ref="scoreDAO" />
	@Autowired	// 자동 주입 setter를 통해서 annotation하게 되면 자동 등록
	private ScoreDAO ScoreDAO;
	
	@Override
	public int insertScore(ScoreVO vo) {
		return ScoreDAO.insertScore(vo);
	}
	@Override
	public int updateScore(ScoreVO vo) {
		return ScoreDAO.updateScore(vo);
	}
	@Override
	public int deleteScore(ScoreVO vo) {
		return ScoreDAO.deleteScore(vo);
	}
	@Override
	public ScoreVO getScore(ScoreVO vo) {
		return ScoreDAO.getScore(vo);
	}
	@Override
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		return ScoreDAO.getScoreList(vo);
	}

}

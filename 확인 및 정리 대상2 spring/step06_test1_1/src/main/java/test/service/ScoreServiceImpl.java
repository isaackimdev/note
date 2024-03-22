package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;

// 이름을 scoreService로 씀
@Service("scoreService")	// 기능은 같음 Service나 repository나 , 육안으로 보기 쉬우라고 기능별로 이름을 달리 함	
public class ScoreServiceImpl implements ScoreService {
	@Autowired	// 생성자, set 을 통하여 관리함, 자동 생성
	private ScoreDAO scoreDAO;
	
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

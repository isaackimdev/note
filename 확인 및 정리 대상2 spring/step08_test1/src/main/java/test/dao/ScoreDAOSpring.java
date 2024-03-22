package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import test.bean.ScoreVO;

public class ScoreDAOSpring {
	private SqlSession sqlSession;
	// 생성자
	
	public ScoreDAOSpring() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
		
		// 얘를 통해서sql 명령어를 사용하게 됩니다.
		System.out.println("dao 생성자 생성");
	}
	
	public int insertScore(ScoreVO vo) {
		int result = sqlSession.insert("mybatis.scoreMapper.insertScore",vo);
		return result;
	}
	public int updateScore(ScoreVO vo) {
		int result = sqlSession.insert("mybatis.scoreMapper.updateScore",vo);
		return result;
	}
	public int deleteScore(ScoreVO vo) {
		int result = sqlSession.insert("mybatis.scoreMapper.deleteScore",vo);
		return result;
	}
	public ScoreVO getScore(ScoreVO vo) { // mapping의 nameplice.id
		return sqlSession.selectOne("mybatis.scoreMapper.getScore",vo);	//태그이름
	}
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList",vo);
	}
	
	// Spring특징은 의존성을 적게
	// 수정할때 적게 고침...계속 분리
}

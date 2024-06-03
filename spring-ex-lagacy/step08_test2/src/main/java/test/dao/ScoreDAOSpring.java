package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.bean.ScoreVO;

@Transactional	// 자동 생성
public class ScoreDAOSpring {
	private SqlSessionTemplate sqlSession;

	public ScoreDAOSpring(SqlSessionTemplate sqlSessionTemplate) {
		sqlSession = sqlSessionTemplate; 
				//SqlMapClientFactory.getSqlMapClientInstance();
	}
	// CRUD 기능의 메소드 구현
	// 성적 등록
	public int insertScore(ScoreVO vo) {
								// namespace id로써 얻어오기
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);	// sql문 등록하기 
	}
	// 성적 수정
	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);	// sql문 등록하기 
	}	
	// 성적 삭제
	public int deleteScore(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);	// sql문 등록하기 
	}
	// 성적 상세 조회
	public ScoreVO getScore(ScoreVO vo) {
		return sqlSession.selectOne("mybatis.scoreMapper.getScore",vo);
	}
	// 성적 목록 조회
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList",vo);	
	}
	
}

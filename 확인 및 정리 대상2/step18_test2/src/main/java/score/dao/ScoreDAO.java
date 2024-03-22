package score.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository	// 어노테이션 등록 > 객체 자동 생성
public class ScoreDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	// SQL 명령어들
	/*
	private final String SCORE_INSERT = "insert into score1 values (?,?,?,?,?,?,?,sysdate)";
	private final String SCORE_UPDATE = "update score1 set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	private final String SCORE_DELETE = "delete score1 where studNo=?";
	private final String SCORE_GET = "select * from score1 where studNo=?";
	private final String SCORE_LIST = "select * from score1 order by studNo asc";	// 학번 기준으로 정렬
	private final String SCORE_COUNT = "select count(*) from score1";
	 */
	
	// 성적 입력
	public int insertScore(ScoreDTO scoreDTO) {
		return sqlSession.insert("mybatis.scoreMapper.insertScore", scoreDTO);
	}
	
	// 성적 수정
	public int updateScore(ScoreDTO scoreDTO) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", scoreDTO);
	}
	
	// 성적 삭제
	public int deleteScore(ScoreDTO scoreDTO) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", scoreDTO);
	}
	
	// 성적 상세 조회
	public ScoreDTO getScore(ScoreDTO scoreDTO) {
		return sqlSession.selectOne("mybatis.scoreMapper.getScore", scoreDTO);
	}
	
	// 성적 목록 조회 1
	public List<ScoreDTO> getScoreList(ScoreDTO scoreDTO) {
		return null;
	}
	// 성적 목록 조회 2
	public List<ScoreDTO> getScoreList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList", map);
	}
	
	// 성적 총 목록 수
	public int selectListCount() {
		return sqlSession.selectOne("mybatis.scoreMapper.selectListCount");
	}

}

















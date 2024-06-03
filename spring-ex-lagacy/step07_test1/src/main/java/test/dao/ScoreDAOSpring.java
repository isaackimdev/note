package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository	// 어노테이션으로 bean 객체를 만드는 것.. 자동 주입
public class ScoreDAOSpring {
	@Autowired	// DAO의 set으로써, 객체를 자동으로 등록시킴
	private JdbcTemplate jdbcTemplate;
	// SQL 명령어들
	private final String SCORE_INSERT = "insert into score1 values (?,?,?,?,?,?,?,sysdate)";
	private final String SCORE_UPDATE = "update score1 set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	private final String SCORE_DELETE = "delete score1 where studNo=?";
	private final String SCORE_GET = "select * from score1 where studNo=?";
	private final String SCORE_LIST = "select * from score1 order by studNo asc";
	// CRUD 기능의 메소드 구현
	// 학생 점수 등록
	public int insertScore(ScoreVO vo) {
		int result = 0;
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(),
				vo.getMat(), vo.getTot(), vo.getAvg()};	// Object 배열을 사용하게 되면
														// 자료형에 상관없이 배열로 만들 수 있다는 큰 장점이 있다.
		result = jdbcTemplate.update(SCORE_INSERT, args);
		return result;
	}
	// 학생 점수 수정
	public int updateScore(ScoreVO vo) {
		int result = 0;
		Object[] args = {vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), 
				vo.getAvg(),vo.getStudNo()};
		result = jdbcTemplate.update(SCORE_UPDATE, args);
		return result;
	}
	// 학생 점수 삭제
	public int deleteScore(ScoreVO vo) {
		int result = 0;
		result = jdbcTemplate.update(SCORE_DELETE, vo.getStudNo());
		return result;
	}
	// 학생 점수 상세조회
	public ScoreVO getScore(ScoreVO vo) {
		Object[] args = {vo.getStudNo() };
		ScoreVO scoreVO
		 = jdbcTemplate.queryForObject(SCORE_GET, args, new ScoreRowMapper() );
		return scoreVO ;
	}
	// 학생 점수 목록조회
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		List<ScoreVO> list = jdbcTemplate.query(SCORE_LIST, new ScoreRowMapper() );
		return list ;	// jdbcTemplate.quert가 내부적으로 list에 담아서 return 함
						// list 별도로 안만들어도 리턴 가능
	}
	// 학생 점수 명단 수 조회
	public int getScoreCount(ScoreVO vo) {
		int result = jdbcTemplate.queryForObject("select count(*) from score1", Integer.class);
		return result;
	}

}

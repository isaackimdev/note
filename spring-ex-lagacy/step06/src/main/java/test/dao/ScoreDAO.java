package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
	private final String SCORE_INSERT
		= "insert into score1 values (?,?,?,?,?,?,?, sysdate)";
	private final String SCORE_UPDATE
		= "update score1 set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	private final String SCORE_DELETE = "delete score1 where studNo=?";
	private final String SCORE_GET = "select * from score1 where studNo=?";
	private final String SCORE_LIST = "select * from score1 order by studNo asc";
	
	// CRUD 기능의 메소드 구현
	// 점수 등록
	public int insertScore(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SCORE_INSERT);
			pstmt.setString(1, vo.getStudNo());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMat());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 점수 수정
	public int updateScore(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SCORE_UPDATE);
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMat());
			pstmt.setInt(4, vo.getTot());
			pstmt.setDouble(5, vo.getAvg());
			pstmt.setString(6, vo.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 점수 삭제
	public int deleteScore(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SCORE_DELETE);
			pstmt.setString(1, vo.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 점수 상세 조회
	public ScoreVO getScore(ScoreVO vo) {
		conn = JDBCUtil.getConnection();
		ScoreVO scoreVO = null;
		try {
			pstmt = conn.prepareStatement(SCORE_GET);
			pstmt.setString(1, vo.getStudNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				scoreVO = new ScoreVO();
				scoreVO.setStudNo(rs.getString("studNo"));
				scoreVO.setName(rs.getString("name"));
				scoreVO.setKor(rs.getInt("kor"));
				scoreVO.setEng(rs.getInt("eng"));
				scoreVO.setMat(rs.getInt("mat"));
				scoreVO.setTot(rs.getInt("tot"));
				scoreVO.setAvg(rs.getInt("avg"));
				scoreVO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return scoreVO;
	}
	// 점수 목록 조회
	public List<ScoreVO> getScoreList(ScoreVO vo) {
		conn = JDBCUtil.getConnection();
		List<ScoreVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(SCORE_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVO scoreVO = new ScoreVO();
				scoreVO.setStudNo(rs.getString("studNo"));
				scoreVO.setName(rs.getString("name"));
				scoreVO.setKor(rs.getInt("kor"));
				scoreVO.setEng(rs.getInt("eng"));
				scoreVO.setMat(rs.getInt("mat"));
				scoreVO.setTot(rs.getInt("tot"));
				scoreVO.setAvg(rs.getInt("avg"));
				scoreVO.setLogtime(rs.getString("logtime"));
				list.add(scoreVO);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
}

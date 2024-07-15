package score.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import score.bean.ScoreDTO;

public class ScoreDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "jspexam";
	private String password = "m1234";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// SQL 명령어들
	/*
	private final String SCORE_INSERT = "insert into score1 values (?,?,?,?,?,?,?,sysdate)";
	private final String SCORE_UPDATE = "update score1 set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	private final String SCORE_DELETE = "delete score1 where studNo=?";
	private final String SCORE_GET = "select * from score1 where studNo=?";
	private final String SCORE_LIST = "select * from score1 order by studNo asc";	// 학번 기준으로 정렬
	private final String SCORE_COUNT = "select count(*) from score1";
	 */
	
	public ScoreDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		 try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return conn;
	}	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 성적 입력
	public int insertScore(ScoreDTO scoreDTO) {
		String sql="insert into score1 values(?,?,?,?,?,?,?,sysdate)";
		int result = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scoreDTO.getStudNo());
			pstmt.setString(2, scoreDTO.getName());
			pstmt.setInt(3, scoreDTO.getKor());
			pstmt.setInt(4, scoreDTO.getEng());
			pstmt.setInt(5, scoreDTO.getMat());
			pstmt.setInt(6, scoreDTO.getTot());
			pstmt.setDouble(7, scoreDTO.getAvg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 수정
	public int updateScore(ScoreDTO scoreDTO) {
		String sql="update score1 set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
		int result = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scoreDTO.getKor());
			pstmt.setInt(2, scoreDTO.getEng());
			pstmt.setInt(3, scoreDTO.getMat());
			pstmt.setInt(4, scoreDTO.getTot());
			pstmt.setDouble(5, scoreDTO.getAvg());
			pstmt.setString(6, scoreDTO.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 삭제
	public int deleteScore(ScoreDTO scoreDTO) {
		String sql="delete score1 where studNo=?";
		int result = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scoreDTO.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 상세 조회
	public ScoreDTO getScore(ScoreDTO scoreDTO) {
		String sql="select * from score1 where studNo=?";
		conn = getConnection();
		ScoreDTO dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scoreDTO.getStudNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ScoreDTO();
				dto.setStudNo(rs.getString("studNo"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	// 성적 목록 조회 1
	public List<ScoreDTO> getScoreList(ScoreDTO scoreDTO) {
		List<ScoreDTO> list = new ArrayList<>();
		String sql="select * from score1 order by studNo asc";
		ScoreDTO dto = null;
		
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new ScoreDTO();
				dto.setStudNo(rs.getString("studNo"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setLogtime(rs.getString("logtime"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 성적 목록 조회 2
	public ArrayList<ScoreDTO> getScoreList(int startNum, int endNum){
		ArrayList<ScoreDTO> list = new ArrayList<>();
		String sql = "select * from (select rownum rn, tt.* from "
				+ " (select * from score1 order by studNo asc) tt) "
				+ " where rn>=? and rn<=? ";
		ScoreDTO scoreDTO = null;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				scoreDTO = new ScoreDTO();
				scoreDTO.setStudNo(rs.getString("studNo"));
				scoreDTO.setName(rs.getString("name"));
				scoreDTO.setKor(rs.getInt("kor"));
				scoreDTO.setEng(rs.getInt("eng"));
				scoreDTO.setMat(rs.getInt("mat"));
				scoreDTO.setTot(rs.getInt("tot"));
				scoreDTO.setAvg(rs.getDouble("avg"));
				scoreDTO.setLogtime(rs.getString("logtime"));
				
				list.add(scoreDTO);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 성적 총 목록 수
	public int getTotalA() {
		int totalA = 0;
		String sql="select count(*) from score1";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt(1);	// 첫번째 항목의 값을 얻어라
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
		
	}
	
	public int selectListCount() {
		int listCount = 0;
		String sql = "select count(*) from score1";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return listCount;
	}

}
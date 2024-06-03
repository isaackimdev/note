package score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import score.bean.ScoreDTO;

public class ScoreDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	public ScoreDAO() {
		try {
			Context context = new InitialContext();
			// tomcat 은 : "java:comp/env/" 를 붙여야 함.
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 성적 1명 등록
	public int insertScore(ScoreDTO scoreDTO) {
		String sql="insert into score values (?,?,?,?,?,?,?)";
		int insertCount = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scoreDTO.getScore_num());
			pstmt.setString(2, scoreDTO.getScore_name());
			pstmt.setInt(3, scoreDTO.getScore_kor());
			pstmt.setInt(4, scoreDTO.getScore_eng());
			pstmt.setInt(5, scoreDTO.getScore_mat());	
			pstmt.setInt(6, scoreDTO.getScore_tot());
			pstmt.setDouble(7, (double)(scoreDTO.getScore_avg()));
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		} finally {
			close();
		}
		return insertCount;	
	}
	public ArrayList<ScoreDTO> scoreList(int startNum, int endNum) {
		ArrayList<ScoreDTO> list = new ArrayList<>();
		String sql = "select * from (select rownum rn, tt.* from "  
		+ "(select * from score order by score_avg desc) tt) "  
		+ "where rn>=? and rn<=?";
		try {
			con =ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreDTO scoreDTO = new ScoreDTO();
				scoreDTO.setScore_num(rs.getInt("score_num"));
				scoreDTO.setScore_name(rs.getString("score_name"));
				scoreDTO.setScore_kor(rs.getInt("score_kor"));
				scoreDTO.setScore_eng(rs.getInt("score_eng"));
				scoreDTO.setScore_mat(rs.getInt("score_mat"));
				scoreDTO.setScore_tot(rs.getInt("score_tot"));
				scoreDTO.setScore_avg(rs.getDouble("score_avg"));
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
	//글의 개수 구하기.
	public int selectListCount() {
		int listCount = 0;
		String sql = "select count(*) from score";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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

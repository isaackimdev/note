package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardBean;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataSource ds = null;	// 커넥션 풀을 관리하는 클래스
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			// Tomcat 인 경우, "java:comp/env/" 를 붙여야 한다.
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
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
	// 이전까지는 auto commit 이였습니다.
	public void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("commit success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("rollback success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 글 등록
	public int insertArticle (BoardBean boardBean) {
		String sql =
			"insert into board2 values (seq_num.nextval, ?, ?, ?, ?, ?, " +
			" seq_num.currval, 0, 0, 0, sysdate)" ;				// current value 현재 값 가지고 오기
		int insertCount = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_name());
			pstmt.setString(2, boardBean.getBoard_pass());
			pstmt.setString(3, boardBean.getBoard_subject());
			pstmt.setString(4, boardBean.getBoard_content());
			pstmt.setString(5, boardBean.getBoard_file());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return insertCount;
	}
}

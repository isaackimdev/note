package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String username = "jspexam";
//	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	// import javax.sql.DataSource;
	private DataSource ds;
	
	// OracleDriver 클래스가 등록되어 있는 지 확인
	// 1. 데이터베이스와 연결하는 드라이버 파일을 찾는다.
	public BoardDAO() {		
		try {
			// import javax.naming.Context;
			// import javax.naming.InitialContext;
			// InitialContext 객체 생성
			Context context = new InitialContext();
			// Tomcat 인 경우, "java:comp/env/"를 붙여야 한다.
			// context.xml의 context => Resource > name 까지를 나타낸다.
			// Context 클래스의 lookup() 메소드는 "java:comp/env/jdbc/oracle"를 가지고 
			// DataSource 객체를 구한다.
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	// 2. 연결을 관리하는 Connection 객체를 생성한다.
//	public Connection getConnection() {
//		try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 3. SQL 작업 처리
	public int boardWrite(BoardDTO boardDTO) {
		String sql 
			= "insert into board values (seq_board.nextval, ?, ?, ?, ?, 0, sysdate)";
		//conn = getConnection();		
		int su = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getContent());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	public ArrayList<BoardDTO> boardList(int startNum, int endNum) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select seq, id, name, subject, content, hit, "
				+ " to_char(logtime, 'YYYY.MM.DD') as logtime from "  
				+ " (select rownum rn, tt.* from "  
				+ " (select * from board order by seq desc) tt) " 
				+ " where rn>=? and rn<=?";
		BoardDTO boardDTO = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			list = null;	// 예외상황 발생시 null로 초기화
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public BoardDTO boardView(int seq) {
		String sql = "select * from board where seq=?";
		BoardDTO boardDTO = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			boardDTO = null;	// 예외상황 발생시 null로 초기화
			e.printStackTrace();
		} finally {
			close();
		}
		return boardDTO;
	}
	
	public int updateHit(int seq) {
		String sql = "update board set hit = hit+1 where seq=?";
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	public int boardDelete(int seq) {
		String sql = "delete board where seq=?";
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	public int getTotalA() {	//Total Article number
		String sql = "select count(*) from board";
		int totalA = 0;
		try {
			conn = ds.getConnection();
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
	
	public int boardModify(BoardDTO boardDTO) {
		String sql = "update board set subject=?, content=? where seq=?";
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getSeq());
			su = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
}





















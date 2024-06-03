package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardBean;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			// Tomcat 인 경우, "java:comp/env/"를 붙여야 한다.
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
	
	public void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 글 등록
	public int insertArticle(BoardBean boardBean) {
		String sql = "insert into board2 values " + 
				"(seq_num.nextval, ?, ?, ?, ?, ?, " + 
				" seq_num.currval, 0, 0, 0, sysdate)";
		int insertCount = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
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
	//글의 개수 구하기.
	public int selectListCount() {
		int listCount = 0;
		String sql = "select count(*) from board2";
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
	//글 목록 보기.
	public ArrayList<BoardBean> selectArticleList(int startNum, int endNum) {
		ArrayList<BoardBean> list = new ArrayList<>();
		String sql = "select * from (select rownum rn, tt.* from "  
		+ "(select * from board2 order by board_re_ref desc, board_re_seq asc) tt) "  
		+ "where rn>=? and rn<=?";
//		String sql = "select * from "  
//				+ "(select rownum rn, tt.* from "  
//				+ "(select * from board2 order by board_num desc) tt) "  
//				+ "where rn>=? and rn<=?";
		try {
			con =ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean boardBean = new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num"));
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file(rs.getString("board_file"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getString("board_date"));
				
				list.add(boardBean);				
			}
		} catch (SQLException e) {
			list =null;
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	//글 내용 보기.
	public BoardBean selectArticle(int board_num) {
		String sql = "select * from board2 where board_num=?";
		BoardBean boardBean = null;
		try {
			con =ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardBean = new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num"));
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file(rs.getString("board_file"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getString("board_date"));							
			}
		} catch (SQLException e) {
			boardBean =null;
			e.printStackTrace();
		} finally {
			close();
		}
		
		return boardBean;
	}
	// 조회수 증가시키기
	public int updateReadCount(int board_num) {
		int updateCount = 0;
		String sql = "update board2 set board_readcount = board_readcount + 1"
				   + "where board_num = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return updateCount;
	}
	//글쓴이인지 확인.
	public boolean isArticleBoardWriter(int board_num, String pass) {
		boolean isWriter = false;
		String sql = "select * from board2 where board_num=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("board_pass"))) {
					isWriter = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return isWriter;
	}
	//글 삭제.
	public int deleteArticle(int board_num) {
		int deleteCount = 0;
		String sql = "delete from board2 where board_num=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return deleteCount;
	}
	//글 수정.
	public int updateArticle(BoardBean boardBean) {
		int updateCount = 0;
		String sql = "update board2 set board_subject=?, board_content=? "
					+" where board_num=?";		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_subject());
			pstmt.setString(2, boardBean.getBoard_content());
			pstmt.setInt(3, boardBean.getBoard_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return updateCount;
	}
	
	//글 답변
	public int insertReplyArticle(BoardBean boardBean) {
		String sql = "";
		int insertCount = 0;
		int re_ref = boardBean.getBoard_re_ref();
		int re_lev = boardBean.getBoard_re_lev();
		int re_seq = boardBean.getBoard_re_seq();
		
		try {
			con = ds.getConnection();
			// 기존 답글의 등록 순서를 재정리
			// 원글 re_seq보다 큰 답글 re_seq를 1씩 증가 
			sql = "update board2 set board_re_seq = board_re_seq+1 "
				+ " where board_re_ref=? and board_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			// 추가된 답글의 re_seq는 원글 re_seq에 1 증가한 값을 가진다.
			// 추가된 답글의 re_lev는 원글 re_lev에 1 증가한 값을 가진다.
			re_seq = re_seq + 1;	// 답글_글순서(board_re_seq) = 원글_글순서 + 1
			re_lev = re_lev + 1;	// 답글_단계(board_re_lev) = 원글_단계  + 1
			sql = "insert into board2 " 
				+ "values (seq_num.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_name());
			pstmt.setString(2, boardBean.getBoard_pass());
			pstmt.setString(3, boardBean.getBoard_subject());
			pstmt.setString(4, boardBean.getBoard_content());
			pstmt.setString(5, " ");	//답장에는 파일을 업로드하지 않음.
			pstmt.setInt(6, re_ref);
			pstmt.setInt(7, re_lev);
			pstmt.setInt(8, re_seq);
			pstmt.setInt(9, 0);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return insertCount;
	}
}


















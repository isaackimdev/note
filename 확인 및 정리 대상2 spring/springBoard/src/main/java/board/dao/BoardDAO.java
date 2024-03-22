package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository	// 어노테이션 등록 > 객체 자동 생성
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	//입력
	public int boardWrite(BoardDTO boardDTO) {
		return sqlSession.insert("mybatis.boardMapper.boardWrite", boardDTO);
	}
	
	// 게시판 목록 조회
	public List<BoardDTO> boardList(int startNum, int endNum) {
		/*
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select seq, id, name, subject, content, hit, "
				+ " to_char(logtime, 'YYYY.MM.DD') as logtime " 
				+ " from (select rownum rn, tt.* from " 
				+ " (select * from board order by seq desc) tt) " 
				+ " where rn>=? and rn<=? ";
		BoardDTO boardDTO = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("Id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
		*/
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}
	
	// 게시판 상세 조회
	public BoardDTO boardView(int seq) {
		/*
		String sql = "select * from board where seq=?";
		BoardDTO boardDTO = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("Id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardDTO;
		*/
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}
	// 조회수 증가
	public void updateHit(int seq) {
		/*
		String sql = "update board set hit=hit+1 where seq=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		*/
		sqlSession.update("mybatis.boardMapper.updateHit", seq);
	}
	// 총 목록 수
	public int getTotalA() {
		/*
		int totalA = 0;
		String sql = "select count(*) from board";
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
		*/
		return sqlSession.selectOne("mybatis.boardMapper.getTotalA");
	}
	// 글 삭제
	public int boardDelete(int seq) {
		/*
		String sql = "delete board where seq=?";
		int su = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	*/
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}
}

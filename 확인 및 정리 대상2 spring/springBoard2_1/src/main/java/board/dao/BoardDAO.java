package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;
@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	// 게시글 작성 처리
	public int boardWrite(BoardDTO boardDTO) {
		return sqlSession.insert("mybatis.board.boardWrite", boardDTO);
	}
	// 게시판 목록 보기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.board.boardList", map);
	}
	// 게시글 상세 보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.board.boardView", seq);
	}
	// 조회수 증가
	public void updateHit(int seq) {
		sqlSession.update("mybatis.board.updateHit", seq);
	}
	// 게시글 삭제하기
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.board.boardDelete", seq);
	}
	// 게시글 갯수 얻어오기
	public int getTotalA() {	//Total Article number
		return sqlSession.selectOne("mybatis.board.getTotalA");
	}
	// 게시글 수정하기
	public int boardModify(BoardDTO boardDTO) {
		return sqlSession.update("mybatis.board.boardModify", boardDTO);
	}
}





















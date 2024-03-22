package board.controller;

import java.util.ArrayList;

import board.bean.BoardDTO;

public interface BoardService {
	// CRUD 기능의 메소드
	// 글 등록
	int boardWrite(BoardDTO boardDTO);
	// 글 수정
	int boardModify(BoardDTO boardDTO);
	// 글 삭제
	int boardDelete(int seq);
	// 글 상세 조회
	BoardDTO boardView(int seq);
	// 글 목록 조회
	ArrayList<BoardDTO> boardList(int startNum, int endNum);
	// 조회수 증가
	void updateHis(int seq);
	// 전체 게시판 글 갯수 조회
	int getTotalA();
	
	int updateBoard(int seq);
}

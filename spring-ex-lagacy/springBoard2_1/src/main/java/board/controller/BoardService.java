package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	public int boardWrite(BoardDTO boardDTO);
	public List<BoardDTO> boardList(int startNum, int endNum);
	public BoardDTO boardView(int seq);
	public void updateHit(int seq);
	public int boardDelete(int seq);
	public int getTotalA();
	public int boardModify(BoardDTO boardDTO);
}

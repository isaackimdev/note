package board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service	// 객체 생성 어노테이션
public class BoardServiceImpl implements BoardService {
	@Autowired	// 생성자와 setter / getter 초기화 및 내부적으로 동작시킴
	private BoardDAO boardDAO;
	
	@Override
	public int boardWrite(BoardDTO boardDTO) {
		return boardDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardModify(BoardDTO boardDTO) {
		return 0;
	}

	@Override
	public int boardDelete(int seq) {
		return boardDAO.boardDelete(seq);
	}

	@Override
	public BoardDTO boardView(int seq) {
		return boardDAO.boardView(seq);
	}

	@Override
	public ArrayList<BoardDTO> boardList(int startNum, int endNum) {
		return (ArrayList<BoardDTO>)boardDAO.boardList(startNum, endNum);
	}

	@Override
	public void updateHis(int seq) {
		boardDAO.updateHit(seq);
	}

	@Override
	public int getTotalA() {
		return boardDAO.getTotalA();
	}

}

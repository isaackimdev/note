package score.controller;

import java.util.ArrayList;
import java.util.List;

import score.bean.ScoreDTO;

public interface ScoreService {
	// CRUD 기능
	// 성적 등록
	int insertScore(ScoreDTO scoreDTO);
	// 성적 수정
	int updateScore(ScoreDTO scoreDTO);
	// 성적 삭제
	int deleteScore(ScoreDTO scoreDTO);
	// 성적 상세 조회
	ScoreDTO getScore(ScoreDTO scoreDTO);
	// 성적 목록 조회2
	List<ScoreDTO> getScoreList(int startNum, int endNum);
	// 성적 총 목록 수
	int selectListCount();

}

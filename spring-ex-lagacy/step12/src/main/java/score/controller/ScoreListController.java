package score.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적 목록 처리");
		// 1. 사용자 입력 정보 추출 (data)
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		// DB - 1페이지당 5개씩
		int endNum = pg * 5;		//	5, 10, 15...
		int startNum = endNum - 4;	//  1,  6, 11...
		ScoreDAO scoreDAO = new ScoreDAO();
		ArrayList<ScoreDTO> list =scoreDAO.getScoreList(startNum, endNum);
		// 페이징 처리
		int totalA = scoreDAO.getTotalA();	// 총글 수
		int totalP = (totalA + 4)/5;		// 총페이지 수
		// 페이징 3개씩 보여주기
		int startPage = (pg-1)/3*3+1;	//	1, 4, 7
		int endPage = startPage + 2;	//	3, 6, 9
		if(endPage> totalP) endPage = totalP;
		// 3. 검색 결과를 request에 저장하고 목록 화면으로 이동한다.
		request.setAttribute("list", list);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("maxPage", totalP);
		request.setAttribute("pg", pg);
		return "scoreList";
	}

}

package score.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.RegexHelper;
import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController2 implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적목록처리");
		ArrayList<ScoreDTO> list = null;
		int pg = 1;
		int limit = 5;
		String str = request.getParameter("pg");
		// 문자열을 숫자로 변환할 때
		// 1. null 확인 2. 숫자만으로 구성되었는지 => ★정규표현식으로 검사★		
		if(RegexHelper.getInstance().isNum(str)) {
			pg = Integer.parseInt(str);
		}
		int endNum = pg * limit;				// 5, 10, 15..
		int startNum = endNum - (limit - 1);	// 1, 6, 11..
		
		ScoreDAO scoreDAO = new ScoreDAO();
		list = (ArrayList<ScoreDTO>)scoreDAO.getScoreList(startNum, endNum);	// 값들을 list에 담는다. 다섯개씩
		
		int listCount = scoreDAO.selectListCount();	// 총 갯수를 가지고 온다.
		
		int maxPage = (listCount + limit - 1 ) / limit;		// (26 + 5 - 1) / 5
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage + 2;
		if(endPage > maxPage) endPage = maxPage;
		// 3. 내용공유 및 페이지 이동
		request.setAttribute("list", list);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("pg", pg);

		return "scoreList";	// "./scoreList.jsp";
	}

}

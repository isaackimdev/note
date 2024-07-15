package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreWriteController2 implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적등록처리");
		// 데이터 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int insertCount = 0 ;
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(request.getParameter("studNo"));
		scoreDTO.setName(request.getParameter("name"));
		
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
		scoreDTO.setKor(kor);
		scoreDTO.setEng(eng);
		scoreDTO.setMat(mat);
		scoreDTO.setTot(tot);
		scoreDTO.setAvg(avg);
		// DB
		ScoreDAO dao = new ScoreDAO();
		insertCount = dao.insertScore(scoreDTO);
		
		request.setAttribute("insertCount" , insertCount);
		
		return "scoreWrite";
	}

}

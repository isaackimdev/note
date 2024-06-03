package score.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller // 1. implement controller 역할, 2. 객체생성 역할
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value="/score/scoreWriteForm.do")
	public ModelAndView scoreWriteForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적 입력 폼 처리");
		//return "scoreWriteForm";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request) {
		// 성적 등록 처리
		System.out.println("성적 등록 처리");
		// 데이터
		// 1. 사용자 입력 정보 추출
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		// 2. DB 연동 처리
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		scoreDTO.setName(name);
		scoreDTO.setKor(kor);
		scoreDTO.setEng(eng);
		scoreDTO.setMat(mat);
		int tot = kor + eng + mat;
		scoreDTO.setTot(tot);
		scoreDTO.setAvg((double)tot/3);
		
		//ScoreDAO scoreDAO = new ScoreDAO();
		int insertCount = scoreService.insertScore(scoreDTO);
		// 3. 화면 네비게이션
//		request.setAttribute("insertCount", insertCount);
//		return "scoreWrite";	// "./" 현재 폴더를 나타냄
								// ./scoreWrite.jsp => viewResolver를 통해서 완성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("insertCount", insertCount);
		modelAndView.setViewName("scoreWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request) {
		System.out.println("성적 상세보기 조회");
		// 1. 사용자 입력 정보 추출
		String studNo = request.getParameter("studNo");
		int pg =  Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		//ScoreDAO scoreDAO = new ScoreDAO();
		
		
		// 상세보기
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		
		ScoreDTO vo = scoreService.getScore(scoreDTO);
		
		// 3. 검색 결과를 request에 저장하고 상세 화면으로 이동한다.
//		request.setAttribute("scoreDTO", vo);
//		request.setAttribute("studNo", studNo);
//		request.setAttribute("pg", pg);
//		return "scoreView";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("scoreDTO", vo);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request) {
		System.out.println("성적 목록 처리");
		// 1. 사용자 입력 정보 추출 (data)
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		// DB - 1페이지당 5개씩
		int endNum = pg * 5;		//	5, 10, 15...
		int startNum = endNum - 4;	//  1,  6, 11...
		//ScoreDAO scoreDAO = new ScoreDAO();
		ArrayList<ScoreDTO> list =scoreService.getScoreList(startNum, endNum);
		// 페이징 처리
		int totalA = scoreService.getTotalA();	// 총글 수
		int totalP = (totalA + 4)/5;		// 총페이지 수
		// 페이징 3개씩 보여주기
		int startPage = (pg-1)/3*3+1;	//	1, 4, 7
		int endPage = startPage + 2;	//	3, 6, 9
		if(endPage> totalP) endPage = totalP;
		// 3. 검색 결과를 request에 저장하고 목록 화면으로 이동한다.
//		request.setAttribute("list", list);
//		request.setAttribute("endPage", endPage);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("maxPage", totalP);
//		request.setAttribute("pg", pg);
//		return "scoreList";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("maxPage", totalP);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적 삭제 처리");
		// 1. 사용자 입력 정보 추출
		String studNo = request.getParameter("studNo");
		int pg = 1; // Integer.parseInt(request.getParameter("pg"));
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		// 2. DB 연동 처리
		//ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		
		int su = scoreService.deleteScore(scoreDTO);
		
		//
//		request.setAttribute("su", su);
//		request.setAttribute("pg", pg);
//		return "scoreDelete";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);	// 전달할 데이터
		modelAndView.addObject("pg", pg);	// 전달할 테이터
		modelAndView.setViewName("scoreDelete.jsp");
		return modelAndView;
	}	
}




















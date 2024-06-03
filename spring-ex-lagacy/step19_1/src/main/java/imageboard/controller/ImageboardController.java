package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

@Controller
public class ImageboardController { // 메소드 방식 설정 default값은 get 방식
	// 등록 화면
	@RequestMapping(value="/imageboard/imageboardWriteForm", method=RequestMethod.GET)
	public String imageboardWriteForm() {
		System.out.println("글 입력 폼 처리");
		// 1. 화면 네비게이션
		return "imageboardWriteForm";
	}
	// 입력 데이터 저장
	@RequestMapping(value="/imageboard/imageboardWrite", method=RequestMethod.POST)
	public ModelAndView imageboardWrite(HttpServletRequest request,
			ImageboardDAO imageboardDAO, MultipartFile image) {
		System.out.println("글 등록 처리");
		// 파일 처리
		String filePath =
			"E:\\java_web_4\\spring\\workspace\\step19_1\\src\\main\\webapp\\storage";
		String fileName = image.getOriginalFilename();
		File file = new File(filePath, fileName);
		try {
			// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
			FileCopyUtils.copy(image.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 1. 사용자 입력 정보 추출
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(request.getParameter("imageId"));
		imageboardDTO.setImageName(request.getParameter("imageName"));
		imageboardDTO.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		imageboardDTO.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		imageboardDTO.setImageContent(request.getParameter("imageContent"));
		imageboardDTO.setImage1(fileName);
		// 2. DB 연동 처리
		int su = imageboardDAO.imageboardWrite(imageboardDTO);
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("imageboardWrite");
		return modelAndView;
	}
	// 목록 조회
	@RequestMapping(value="/imageboard/imageboardList")
	public ModelAndView imageboardList(HttpServletRequest request,
			ImageboardDAO imageboardDAO) {
		System.out.println("글 목록 처리");
		// 1. 사용자 입력 정보 추출
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동처리
		// DB - 1페이지당 5개씩
		int endNum = pg * 5;		// 5, 10, 15..
		int startNum = endNum - 4;  // 1, 6, 11..
		ArrayList<ImageboardDTO> list =
				imageboardDAO.imageboardList(startNum, endNum);
		// 페이징 처리
		int totalA = imageboardDAO.getTotalA();
		int totalP = (totalA + 4) / 5; // 총 페이지 수
		// 3블럭으로 
		int startPage = (pg - 1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardList");
		return modelAndView;
	}
	// 상세보기 조회
	@RequestMapping(value="/imageboard/imageboardView")
	public ModelAndView imageboardView(HttpServletRequest request,
			ImageboardDAO imageboardDAO) {
		System.out.println("글 상세 조회 처리");
		// 1. 검색할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		ImageboardDTO imageboardDTO = imageboardDAO.imageboardView(seq);
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardView");
		return modelAndView;
	}
	// 삭제 처리 
	@RequestMapping(value="/imageboard/imageboardDelete")
	public ModelAndView imageboardDelete(HttpServletRequest request,
			ImageboardDAO imageboardDAO) {
		System.out.println("글 삭제 처리");
		// 1. 사용자 입력 정보 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		int su = imageboardDAO.boardDelete(seq);
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardDelete");
		return modelAndView;
	}	
}


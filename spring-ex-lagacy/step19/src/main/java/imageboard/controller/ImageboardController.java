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
public class ImageboardController {	// 데이터 처리
	
	// 페이지 이동 경로가 이름만 올 경우, web.xml 에 url 패턴을 *.do
	// 로 바꾸지 않고, 기존 그대로 " / " 로 설정해준다.
	
	// 등록 화면
	@RequestMapping(value="/imageboard/imageboardWriteForm", method=RequestMethod.GET)
	public String imageboardWriteForm() {
		return "imageboardWriteForm";
			// 모델엔 뷰를 써도 되지만,
			// 문자열로 리턴해도 된다.
			// 클래스마다 함수가 조금씩 다름
			// 어노테이션을 사용하면 편하지만 구조가 안보임.
			// ViewResolver를 별도로 만들어 졌음
			// mvc-config.xml 에 설정되어 있음
	}
	
	// * 이름만 쓰는 경우에는 메소드방식도 매개변수로 지정해줘야 하는 듯..
	// 첫번째 제약 : 파라미터 MultipartFile image는 <input type="file" name="image"> input 태그의
	// name과 일치해야 한다.	

	// 입력 데이터 저장
	@RequestMapping(value="/imageboard/imageboardWrite", method=RequestMethod.POST)
	public ModelAndView imageboardWrite(
		HttpServletRequest request,	
		MultipartFile image) {	// MultipartFile image 파일은 저장되어 있다.		
		
		/* 					
		 커맨드 객체의 특징으로 매개변수의 변수값을
		 ModelAndView에 담지 않더라도 계속 전달하고 있음.
		 
		 step16 Controller와 비교 했을 때, DTO가 메소드 내부에 생성된 것들이 보이는데,
		 그 값을 ModelAndView에 직접 담아 전달하고 있는 것을 확인할 수 잇다.
		 */
		
		String filePath = "E:/java_web_4/spring/workspace/step19/src/main/webapp/storage";	// 파일 경로
		// "E:\\java_web_4\\spring\\workspace\\step19_1\\src\\main\\webapp\\storage";
		String fileName = image.getOriginalFilename();	// 파일 이름 얻기
		
		File file = new File(filePath, fileName);	// 폴더 이름과 파일 이름이 현재 결합된 것.
		
		// 파일 복사
		try {
			// metadata에서 image를 copy해 온다. 
			// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
			FileCopyUtils.copy(image.getInputStream(), new FileOutputStream(file));
			
			System.out.println("storage에 이미지 저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1. ImageboardDTO에 입력 정보 및 fileName을 DTO에 담는다.
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(request.getParameter("imageId"));
		imageboardDTO.setImageName(request.getParameter("imageName"));
		imageboardDTO.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		imageboardDTO.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		imageboardDTO.setImageContent(request.getParameter("imageContent"));
		imageboardDTO.setImage1(fileName);
		// 2. DB
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		int su = imageboardDAO.imageboardWrite(imageboardDTO);
		// 3. ModelAndView return
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		modelAndView.addObject("su" , su);
		modelAndView.setViewName("imageboardWrite");
		return modelAndView;
	}
	
	// 글 목록처리 /* 2018-08-23 */
	@RequestMapping(
		value="/imageboard/imageboardList",
		method=RequestMethod.GET
	)
	public ModelAndView imageboardList(HttpServletRequest request) {
		// 1. 사용자 입력 정보 추출 (data)
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동처리
		// DB - 1페이지당 5개씩
		int endNum = pg * 5;	//	5, 10, 15...
		int startNum = endNum - 4;	// 1, 6, 11...
		
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		ArrayList<ImageboardDTO> list
			= imageboardDAO.imageboardList(startNum, endNum);
		
		//// 테스트
//		Iterator<ImageboardDTO> it = list.iterator();
//		ImageboardDTO dto = new ImageboardDTO();
//		while(it.hasNext()) {
//			dto = it.next();
//			System.out.println(dto.toString());
//		}
		
		// 페이징 처리
		int totalA = imageboardDAO.getTotalA(); 	// 총글 수
		int totalP = (totalA + 4) / 5; 				// 총 페이지 수
		
		// 페이징 3개씩 보여주기
		int startPage = (pg-1)/3*3+1;	// 1, 4, 7....
		int endPage = startPage + 2;	// 3, 6, 9
		if(endPage > totalP) endPage = totalP;
	
		// 3. 화면 navigation
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardList");
		return modelAndView;
	}
	
	// 이미지게시판 상세보기
	@RequestMapping(
		value="/imageboard/imageboardView",
		method=RequestMethod.GET
	)
	public ModelAndView imageboardView(
			HttpServletRequest request,
			ImageboardDAO imageboardDAO // 이렇게 해도 객체 생성되는지 확인 해봐야 함.
		) {
		System.out.println("이미지 게시판 상세보기 처리");
		// 1. 사용자 입력 정보 추출 (Data)
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ImageboardDTO imageboardDTO = imageboardDAO.imageboardView(seq);
		
		// 3. 화면 navigation
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardView");
		return modelAndView; 
	}

	// 삭제 처리 
	@RequestMapping(value="/imageboard/imageboardDelete")
	public ModelAndView imageboardDelete(
		HttpServletRequest request,
		ImageboardDAO imageboardDAO
	) {
		
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB 연동 처리
		int su = imageboardDAO.imageboardDelete(seq);
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardDelete");
		return modelAndView;
	}	
}
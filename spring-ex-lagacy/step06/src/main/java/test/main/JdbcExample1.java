package test.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;
import test.service.GoodsService;
import test.service.GoodsServiceImpl;

public class JdbcExample1 {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		GenericXmlApplicationContext context =	// 어노테이션으로 등록한 것 얻어오기 
			new GenericXmlApplicationContext("applicationContext.xml");	// 원래 위치가 resources 이고, xml파일 명을 바로 써준다.
		// 2. Spring 컨테이너로부터 GoodsServiceImpl 객체를 Lookup한다.
		GoodsService goodsService = 
				context.getBean("goodsService", GoodsServiceImpl.class);
		// 3. 글 등록 기능 테스트
		GoodsVO vo = new GoodsVO();
		vo.setCode("p001");
		vo.setName("삼국지");
		vo.setPrice(10000);
		vo.setMaker("KG아이티뱅크");
		int result = goodsService.insertGoods(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		// 4. 글 수정 기능 테스트
		vo.setCode("p001");
		vo.setName("Java++");
		vo.setPrice(20000);
		vo.setMaker("KG아이티뱅크");
		result = goodsService.updateGoods(vo);
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		// 4. 글 삭제 기능 테스트
		/*vo.setCode("p001");
		result = dao.deleteGoods(vo);
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}*/
		// 4. 글 상세보기 기능 테스트
		vo.setCode("p001");
		vo = goodsService.getGoods(vo);
		if(vo != null) {
			System.out.println(vo.toString());
		}
		
		// 4. 글 목록보기 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList(null);
		for (int i = 0; i<list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
			
		// 5. 컨테이너 종료 
		context.close();
	}
}

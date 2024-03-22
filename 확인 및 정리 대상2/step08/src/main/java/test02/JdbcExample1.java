package test02;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample1 {
	public static void main(String[] args) {

		// 1. Spring 컨테이너를 구동한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("bean2.xml");
		// 2. Spring 컨테이너로부터 GoodsServiceImpl 객체를 Lookup한다.
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		// 3. 글 등록 기능 테스트
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0002");
		vo.setName("Java");
		vo.setPrice(20000);
		vo.setMaker("한샘 출판사");
		int result = goodsService.insertGoods(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		// 4. 글 목록 검색 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList(vo);
		for(GoodsVO goods : list) {
			System.out.println(goods.toString());
		}		
		// 5. Spring 컨테이너 종료
		context.close();
	}
}

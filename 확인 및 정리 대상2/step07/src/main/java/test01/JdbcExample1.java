package test01;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample1 {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("applicationContext2.xml");
		
		//GoodsServiceImpl service = context.getBean("goodsServiceImpl", GoodsServiceImpl.class);
		GoodsServiceImpl goodsService = (GoodsServiceImpl) context.getBean("goodsServiceImpl");
		
		// 3. 글 등록 기능 테스트
		GoodsVO vo1 = new GoodsVO();
		vo1.setCode("p001");
		vo1.setName("스프링");
		vo1.setPrice(20000);
		vo1.setMaker("하샘풀판사");
		GoodsVO vo2 = new GoodsVO();
		vo2.setCode("p002");
		vo2.setName("JSP 3일완성");
		vo2.setPrice(30000);
		vo2.setMaker("야메루풀판사");
		int result = goodsService.insertGoods(vo1);
		result = goodsService.insertGoods(vo2);
		
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패 ");
		}
		// 4. 글 목록 검색 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList(null);
		for(GoodsVO vo : list) {
			System.out.println(vo.toString());
		}
		// 4. 글목록수 확인
		System.out.println("글 목록 수 : "+  goodsService.getGoodsCount(null));
		
		// 5. Spring 컨테이너 종료
		context.close();
	}
}

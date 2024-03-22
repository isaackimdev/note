package test01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		GoodsServiceImpl goodsService = context.getBean("goodsServiceImpl", GoodsServiceImpl.class);
		
		// 삭제기능
		GoodsVO vo1 = new GoodsVO();
		vo1.setCode("p0003");
		int result = goodsService.deleteGoods(vo1);
		if(result > 0) {
			System.out.println(vo1.getCode() + "삭제 성공");
		} else {
			System.out.println(vo1.getCode() + "삭제 실패");
		}
		////////////////////////////////////////////////////////
		// 상세조회 기능
		GoodsVO voReq = new GoodsVO();
		voReq.setCode("p0002");
		
		
		GoodsVO gVO = goodsService.getGoods(voReq);
		if(gVO != null) {
			System.out.println(gVO.toString());
		} else {
			System.out.println("불러오기 실패 ");
		}
		
		
		
		
		
		// 5. Spring 컨테이너 종료 
		context.close();
	}
}

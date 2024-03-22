package test01;

import java.util.List;

public interface GoodsService {
	// CRUD 기능의 메소드
	// 책 등록
	int insertGoods(GoodsVO vo);
	// 책 수정
	int updateGoods(GoodsVO vo);
	// 책 삭제
	int deleteGoods(GoodsVO vo);
	// 책 상세 조회
	GoodsVO getGoods(GoodsVO vo);
	// 책 목록 조회
	List<GoodsVO> getGoodsList(GoodsVO vo);
	
}

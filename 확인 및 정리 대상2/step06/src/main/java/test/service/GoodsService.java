package test.service;

import java.util.List;

import test.bean.GoodsVO;

// Service를 따로 두는 이유는 다양한 테이블과 DAO를 통합 관리하기 위해서이다.
// 목차 역할
public interface GoodsService {
	// 상품등록 CRUD 기능의 메소드
	// 상품 등록
	int insertGoods(GoodsVO vo);
	// 상품 수정
	int updateGoods(GoodsVO vo);
	// 상품 삭제
	int deleteGoods(GoodsVO vo);
	// 상품 상세조회
	GoodsVO getGoods(GoodsVO vo);
	// 상품 목록조회
	List<GoodsVO> getGoodsList(GoodsVO vo);	
}

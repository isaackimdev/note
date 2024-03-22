package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	// <property name="goodsDAO" ref="goodsDAO"/>
	@Autowired	// 자동 주입 setter를 통해서... annotation하게 되면 자동 등록(?)
	private GoodsDAO goodsDAO;
	
	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAO.insertGoods(vo);
	}
	@Override
	public int updateGoods(GoodsVO vo) {
		return goodsDAO.updateGoods(vo);
	}
	@Override
	public int deleteGoods(GoodsVO vo) {
		return goodsDAO.deleteGoods(vo);
	}
	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return goodsDAO.getGoods(vo);
	}
	@Override
	public List<GoodsVO> getGoodsList(GoodsVO vo) {
		return goodsDAO.getGoodsList(vo);
	}
}

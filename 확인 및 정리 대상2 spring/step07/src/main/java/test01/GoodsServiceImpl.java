package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service //("goodsService")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAOSpring goodsDAO;
	
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

	@Override
	public int getGoodsCount(GoodsVO vo) {
		return goodsDAO.getGoodsCount(vo);
	}

}

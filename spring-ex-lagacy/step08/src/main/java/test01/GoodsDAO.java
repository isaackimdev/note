package test01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GoodsDAO {
	private SqlSession sqlSession;
	// 생성자
	
	public GoodsDAO() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
		// 얘를통해서 sql 명령어를 사용하게 됩니다.
	}
	public int insertGoods(GoodsVO vo) {
		int result = sqlSession.insert("mybatis.goodsMapper.insertGoods",vo);	// insert는 태그이름
		return result;
	}
	public int deleteGoods(GoodsVO vo) {
		int result = sqlSession.delete("mybatis.goodsMapper.deleteGoods",vo);	// delete는 태그이름
		return result;
	}
	public int updateGoods(GoodsVO vo) {
		int result = sqlSession.update("mybatis.goodsMapper.updateGoods",vo);	// update는 태그이름
		return result;
	}
	public GoodsVO getGoods(GoodsVO vo) {	// mapping의 (nameplace).(id)
		return sqlSession.selectOne("mybatis.goodsMapper.getGoods",vo);	// 는 태그이름
		
	}
	public List<GoodsVO> getGoodsList(GoodsVO vo) {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList", vo);
	}
	
	
	// Spring특징은 의존성을 적게... 
	// 수정할떄 적게 고치자... 계속 분리시킴...
	
	
}

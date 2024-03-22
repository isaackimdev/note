package test02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;
// 커넥션을 얻어도 오고, close도 시킴
@Transactional
public class GoodsDAO {
	private SqlSessionTemplate sqlSession;
	// 생성자
	
	public GoodsDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
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

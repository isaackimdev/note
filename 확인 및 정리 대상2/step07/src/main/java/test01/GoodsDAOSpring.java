package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository	// 어노테이션이든 <bean> 태그이든 bean 객체를 만드는 것.. 자동주입
public class GoodsDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// SQL 명령어들
	private final String GOODS_INSERT = "insert into goods values (?, ?, ?, ?)";
	private final String GOODS_UPDATE = "update goods set name=?, price=?, maker=? where code=?";
	private final String GOODS_DELETE = "delete goods where code=?";
	private final String GOODS_GET = "select * from goods where code=?";
	private final String GOODS_LIST = "select * from goods order by code asc";
	// CRUD 기능의 메소드 구현
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		result = jdbcTemplate.update(GOODS_INSERT, vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
		return result;	
	}
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		Object[] args = {vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode() };
		result = jdbcTemplate.update(GOODS_UPDATE, args);
		return result;	
	}
	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		int result = 0;
		result = jdbcTemplate.update(GOODS_DELETE, vo.getCode());
		return result;	
	}
	// 책 상세 조회
	public GoodsVO getGoods(GoodsVO vo) {
		Object[] args = {vo.getCode()};
		GoodsVO goodsVO =
				jdbcTemplate.queryForObject(GOODS_GET, args, new GoodsRowMapper());
		return goodsVO;	
	}
	// 책 목록 조회
	public List<GoodsVO> getGoodsList(GoodsVO vo) {
		List<GoodsVO> list = jdbcTemplate.query(GOODS_LIST, new GoodsRowMapper());
		return list;
	}
	// 책 목록수 조회
	public int getGoodsCount(GoodsVO vo) {
		int result
			= jdbcTemplate.queryForObject("select count(*) from goods", Integer.class);
		return result;
	}	
}
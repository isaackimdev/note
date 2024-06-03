package test01;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GoodsRowMapper implements RowMapper<GoodsVO> {	// interface

	@Override			// db 검색 결과를 rs로 받아서 리턴, rowNum : 행번호 database에서 한줄을 의미함
	public GoodsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		GoodsVO vo = new GoodsVO();
		vo.setCode(rs.getString("code"));
		vo.setName(rs.getString("name"));
		vo.setPrice(rs.getInt("price"));
		vo.setMaker(rs.getString("maker"));
		return vo;
	}

}

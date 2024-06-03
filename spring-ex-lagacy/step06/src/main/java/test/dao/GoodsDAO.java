package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

@Repository	// new 붙이지 않은 채 객체 생성 > xml에서 설정
public class GoodsDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
	private final String GOODS_INSERT = "insert into goods values (?, ?, ?, ?)";
	private final String GOODS_UPDATE = "update goods set name=?, price=?, maker=? where code=?";
	private final String GOODS_DELETE = "delete goods where code=?";
	private final String GOODS_GET = "select * from goods where code=?";
	private final String GOODS_LIST = "select * from goods order by code asc";
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_INSERT);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("노 업뎃");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 글 수정
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 글 삭제
	public int deleteGoods(GoodsVO vo) {
		conn = JDBCUtil.getConnection();
		int result = 0;
	
		try {
			pstmt = conn.prepareStatement(GOODS_DELETE);
			pstmt.setString(1, vo.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 글 상세 조회
	public GoodsVO getGoods(GoodsVO vo) {
		conn = JDBCUtil.getConnection();
		GoodsVO goodsVO = null;
		try {
			pstmt = conn.prepareStatement(GOODS_GET);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goodsVO = new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("Maker"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return goodsVO;
	}
	// 글 목록 조회
	public List<GoodsVO> getGoodsList(GoodsVO vo) {
		conn = JDBCUtil.getConnection();
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		
		try {
			pstmt = conn.prepareStatement(GOODS_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GoodsVO goodsVO = new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("maker"));
				list.add(goodsVO);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
		
	}

}

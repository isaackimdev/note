package imageboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;	// 커넥션 풀을 관리하는 클래스
	
	public ImageboardDAO() {
		try {
			Context context = new InitialContext();
			// Tomcat 인 경우, "java:comp/env/"를 붙여야 한다.
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public int imageboardWrite(ImageboardDTO imageboardDTO) {
		String sql 
			= "insert into imageboard values (seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imageboardDTO.getImageId());
			pstmt.setString(2, imageboardDTO.getImageName());
			pstmt.setInt(3, imageboardDTO.getImagePrice());
			pstmt.setInt(4, imageboardDTO.getImageQty());
			pstmt.setString(5, imageboardDTO.getImageContent());
			pstmt.setString(6, imageboardDTO.getImage1());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	public ArrayList<ImageboardDTO> imageboardList(int startNum, int endNum) {
		String sql = "select * from (select rownum rn, tt.* from " + 
				" (select * from imageboard order by seq desc) tt) " + 
				" where rn>=? and rn<=?";
		ArrayList<ImageboardDTO> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ImageboardDTO imageboardDTO = new ImageboardDTO();
				imageboardDTO.setSeq(rs.getInt("seq"));
				imageboardDTO.setImageId(rs.getString("imageId"));
				imageboardDTO.setImageName(rs.getString("imageName"));
				imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
				imageboardDTO.setImageQty(rs.getInt("imageQty"));
				imageboardDTO.setImageContent(rs.getString("imageContent"));
				imageboardDTO.setImage1(rs.getString("image1"));
				list.add(imageboardDTO); 
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public ImageboardDTO imageboardView(int seq) {
		String sql = "select * from imageboard where seq=?";
		ImageboardDTO imageboardDTO = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				imageboardDTO = new ImageboardDTO();
				imageboardDTO.setSeq(rs.getInt("seq"));
				imageboardDTO.setImageId(rs.getString("imageId"));
				imageboardDTO.setImageName(rs.getString("imageName"));
				imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
				imageboardDTO.setImageQty(rs.getInt("imageQty"));
				imageboardDTO.setImageContent(rs.getString("imageContent"));
				imageboardDTO.setImage1(rs.getString("image1"));
			}
		} catch (SQLException e) {
			imageboardDTO = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return imageboardDTO;
	}
	
	public int getTotalA() {
		String sql = "select count(*) from imageboard";
		int totalA = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
	
	public int imageboardDelete(int seq) {
		String sql = "delete imageboard where seq=?";
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, seq); 
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return su;
	}
	
	public int imageboardModify(ImageboardDTO imageboardDTO) {
		String sql = null;
		if(imageboardDTO.getImage1() != null) {
			sql = "update imageboard " 
					+ " set imageId=?, imageName=?, imagePrice=?, imageQty=?, "
					+ " imageContent=?, image1=? where seq=?";
		} else {
			sql = "update imageboard " 
					+ " set imageId=?, imageName=?, imagePrice=?, imageQty=?, "
					+ " imageContent=? where seq=?";
		}
		int su = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, imageboardDTO.getImageId());
			pstmt.setString(2, imageboardDTO.getImageName());
			pstmt.setInt(3, imageboardDTO.getImagePrice());
			pstmt.setInt(4, imageboardDTO.getImageQty());
			pstmt.setString(5, imageboardDTO.getImageContent());
			if(imageboardDTO.getImage1() != null) {
				pstmt.setString(6, imageboardDTO.getImage1());
				pstmt.setInt(7, imageboardDTO.getSeq());
			} else {
				pstmt.setInt(6, imageboardDTO.getSeq());
			}
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
}























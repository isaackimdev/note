package imageboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import imageboard.bean.ImageboardDTO;

@Repository
public class ImageboardDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "jspexam";
	private String password = "m1234";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ImageboardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 이미지 게시판 등록
	public int imageboardWrite(ImageboardDTO imageboardDTO) {
		String sql = "insert into imageboard values (seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		int su = 0;
		conn = getConnection();
		
		try {
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
	// 이미지 게시판 목록 조회
	public ArrayList<ImageboardDTO> imageboardList(int startNum, int endNum) {
		ArrayList<ImageboardDTO> list = new ArrayList<>();
		String sql = "select * from " + 
				" (select rownum rn, tt.* from " + 
				" (select * from imageboard order by seq desc) tt) " + 
				" where rn>=? and rn<=?";
		ImageboardDTO imageboardDTO = null;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				imageboardDTO = new ImageboardDTO();
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
	// 이미지 게시판 상세 조회
	public ImageboardDTO imageboardView(int seq) {
		String sql = "select * from imageboard where seq=? ";
		ImageboardDTO imageboardDTO = null;
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
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
			e.printStackTrace();
		} finally {
			close();
		}
		return imageboardDTO;
	}
	
	// 이미지 게시판 총 목록 수 
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) from imageboard";
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalA = rs.getInt(1);	// 첫번째 항목의 값을 얻어라 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}

	// 이미지 게시판 삭제 기능
	public int imageboardDelete(int seq) {
		String sql ="delete imageboard where seq=?";
		int su = 0;
		conn = getConnection();
		
		try {
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
}


















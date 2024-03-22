package imageboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	// 글번호, 코드, 네임, 가격, 수량, 설명, 이미지, 작성일
	private String driver= "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username ="jspexam";
	private String password ="m1234";
	
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
	
	// 이미지 등록
	public int imageboardWrite(ImageboardDTO imageboardDTO) {
		conn = getConnection();
		int su = 0;
		String sql =
		"insert into imageboard values (seq_imageboard.nextval,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imageboardDTO.getImageId());
			pstmt.setString(2, imageboardDTO.getImageName());
			pstmt.setInt(3, imageboardDTO.getImagePrice());
			pstmt.setInt(4, imageboardDTO.getImageQty());
			pstmt.setString(5, imageboardDTO.getImageContent());
			pstmt.setString(6, imageboardDTO.getImage1());
			su = pstmt.executeUpdate();	// 처리된 데이터 개수가 오게 된다.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 이미지 목록 조회
	public ArrayList<ImageboardDTO> imageboardList(int starNum, int endNum) {
		conn = getConnection();
		ArrayList<ImageboardDTO> list = new ArrayList<>();
		String sql = "select * from	(select rownum rn, tt.* from " 
				+" (select * from imageboard order by seq desc) tt) "
				+" where rn>=? and rn<=?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, starNum);
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
				imageboardDTO.setLogtime(rs.getString("logtime"));
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
	// 이미지 상세보기
	public ImageboardDTO imageboardView(int seq) {
		conn = getConnection();
		ImageboardDTO imageboardDTO = null;
		String sql = "select * from	imageboard where seq=?";
				
		try {
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
				imageboardDTO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			imageboardDTO = null;
			e.printStackTrace();
		} finally {
			close();
		}
		return imageboardDTO;
	}
	// 이미지 총 갯수 구하기
	public int getTotalA() {
		conn = getConnection();
		int totalA = 0;
		String sql = "select count(*) from imageboard";
		
		try {
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
	// 이미지 삭제
	public int boardDelete(int seq) {
		conn = getConnection();
		int su = 0;
		String sql = "delete imageboard where seq=?";
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




































package com.dao;
// DAO : Data Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jspexam";
	String password = "m1234";
	// 1. Driver Loading	
	public SchoolDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. connection
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 3. SQL 작업처리
	// insert
	public int insertArticle(SchoolDTO schoolDTO) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "insert into school values (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schoolDTO.getName());
			pstmt.setString(2, schoolDTO.getValue());
			pstmt.setInt(3, schoolDTO.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}		
		
		return su;
	}
	// select : 전체 검색
	public List<SchoolDTO> selectList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SchoolDTO> list = new ArrayList<SchoolDTO>();
		String sql = "select * from school";
		try {
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SchoolDTO schoolDTO = new SchoolDTO();
				schoolDTO.setName(rs.getString("name"));
				schoolDTO.setValue(rs.getString("value"));
				schoolDTO.setCode(rs.getInt("code"));
				
				list.add(schoolDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		
		return list;
	}
	// select : 부분 검색
	public SchoolDTO selectArticle(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		SchoolDTO schoolDTO = null;
		ResultSet rs = null;
		String sql = "select * from school where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				schoolDTO = new SchoolDTO();
				schoolDTO.setName(rs.getString("name"));
				schoolDTO.setValue(rs.getString("value"));
				schoolDTO.setCode(rs.getInt("code"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		
		return schoolDTO;
	}
	// delete
	public int deleteArticle(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "delete school where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}		
		
		return su;
	}
}















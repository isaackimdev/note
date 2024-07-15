package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO4 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// OracleDriver Ŭ������ ��ϵǾ� �ִ� �� Ȯ��
	// 1. �����ͺ��̽��� �����ϴ� ����̹� ������ ã�´�.
	public MemberDAO4() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. ������ �����ϴ� Connection ��ü�� �����Ѵ�.
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
	// 3. SQL �۾� ó��
	public int write(MemberDTO memberDTO) {
		int su=0;
		conn = getConnection();
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	public int modify(MemberDTO memberDTO) {
		int su=0;
		conn = getConnection();
		String sql = "update member "
			+ " set name=?,pwd=?,gender=?,email1=?,email2=?,tel1=?,tel2=?,tel3=?,addr=? "
			+ " where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getAddr());
			pstmt.setString(10, memberDTO.getId());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// ȸ��1���� ���� �о����
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		conn = getConnection();
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return memberDTO;
	}
	
	public String login(String id, String pwd) {
		String name = null;
		conn = getConnection();
		String sql = "select * from member where id=? and pwd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	
	public boolean isExistId(String id) {
		boolean exist = false;
		conn = getConnection();
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				exist = true;	// id ������ => id ��� �Ұ��� 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return exist;
	}
}















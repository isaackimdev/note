package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

// Data Access Object
public class MemberDAO { //DB에 연결하는 클래스
	String driver = "oracle.jdbc.driver.OracleDriver";	// 패키지가 있음..
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	// 오라클 주소 url
	String username = "jspexam";
	String password = "m1234";
	
	Connection conn;				// 연결 API
	PreparedStatement pstmt;		// 동적 할당 API
	ResultSet rs;					// 결과 셋 API
	
	// OracleDriver 클래스가 등록되어 있는 지 확인
	// 1. 데이터베이스와 연결하는 드라이버 파일을 찾는다. 생성자
	public MemberDAO() {
		try {
			Class.forName(driver);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. 연결을 관리하는 Connection 객체를 생성한다.
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// 3. SQL 작업 처리 
	public int write(MemberDTO memberDTO) {	// write 서버에서 저장된 DTO를 DB에 저장하기 위해 매개 변수를 DTO로 받음.
		int su = 0;
		conn = getConnection();	// 드라이버 매니저를 통하여 오라클의, 유저명, 패스워드를 입력하여 접속한다.
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";	// sql문 을 작성
		
		// 동적 할당
		try {
			pstmt = conn.prepareStatement(sql);		// 동적할당에다가 << 연결conn 동적할당 sql문 등록
			pstmt.setString(1, memberDTO.getName());	// sql ( ? ) 순에다가 동적할당
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			su = pstmt.executeUpdate();	// 동적할당의 개수가 업데이트 되었는지 확인
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 4. SQL 문으로 DB에서 선택 검색하여 name 반환 기능
	public String login (String id, String pwd) {
		String name = null;
		conn = getConnection();
		String sql ="select*from member where id=? and pwd=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {	// 다음의 값이 있다면 다 불러오거라. Generic 참고
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	// 5. 아이디 중복확인하기 
	public boolean isExistId(String id) {
		boolean exist= false;
		conn = getConnection();
		String sql = "select*from member where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				exist = true;	// id 존재함 => id 사용 불가능
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
}

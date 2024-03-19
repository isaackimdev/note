package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest {
	// 1. Driver Loading : 생성자
	// 데이터베이스와 연결하는 드라이버 파일을 찾는다.
	public SelectTest() {
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();	// 실패한 경우 라이브러리가 제대로 등록되지 않은 경우..
		}
	}
	// 2. connection
	public Connection getConnection() {
		Connection conn = null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="jspexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	// 3. SQL 작업처리
	public void selectArticle() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dbtest";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		// 실행 -> 결과값 저장 ,,, 문자열로 받아옴 (이름, data) >>{map구조, key 값과 data 가 불러와짐..}
			// Select 문은 Query 로 실행하게 된다. 한줄씩 한줄씩 집어 넣는다.			
			// 다 넣은 것을 출력
			while(rs.next()) {		// 데이터가 있으면 계속 꺼내오고, 아니면 끝난다.
				String name = rs.getString("name");				// rs.getString(1);	// DB에서 번호로도 꺼내올 수 있다.
				int age = rs.getInt("age");						// rs.getInt(2);
				double height = rs.getDouble("height");			// rs.getDouble(3);
				String logtime = rs.getString("logtime"); 		// rs.getString(4);
				System.out.println(name + "\t" + age + "\t" + height + "\t" + logtime);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		// 작은 클래스 부터 닫아 줌.
			try {	
				if(rs != null) rs.close();	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} 
		}
		
	}
}

public class Exam3 {
	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}
}

package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.net.aso.d;
/**  DB에 있는 데이터 처리하기  */ 
class DeleteTest {
	// 1. Driver Loading
	public DeleteTest() {
		try {	// 드라이버가 있는지.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;		
	}	// 오라클 서버와 연결 된 것.
	// 3. SQL 작업처리
	public void deleteArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		// DB처리
		Connection conn = getConnection();	// 연결시킨 내용을 Connection conn 에 담음
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "delete dbtest where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);	// 첫번째 물음표에 1번 세팅
			su = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 파일 닫기
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(su + "개의 행이 삭제되었습니다.");
		}
	}
}

public class Exam5 {
	public static void main(String[] args) {
		DeleteTest deleteTest = new DeleteTest();
		deleteTest.deleteArticle();
	}
}

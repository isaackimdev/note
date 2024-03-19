package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class UpdateTest {
	// 1. Driver Loading
	
	public UpdateTest() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
	}
	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;					// IP Port Number : 1521
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
	}	// oracle 서버와 연결이 된 것.	
	// 3. SQL 작업처리
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
			
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "update dbtest set age=age+1 where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");	//sql 의 1번 물음표 에 name 이 들어가는 곳
			su = pstmt.executeUpdate();	// insert, delete, update        <==>  select 명령어는 query
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(su + "개의 행이 수정되었습니다.");
	}
}

public class Exam4 {
	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();
	}
}

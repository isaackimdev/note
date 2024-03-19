package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	// 1. Driver Loading
	// 데이터베이스와 연결하는 드라이버 파일을 찾는다.
	public InsertTest() {	// 생성자에 드라이브를 찾아보고 생성 함.
		try {
			// 점검 하는 것.. 있으면 등록할 수 있음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			//e.printStackTrace();
		}
	}
	// 2. connection
	public Connection getConnection() {
		Connection conn = null; // 연결하는 커넥션
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// localhost 같은 pc에 있는 default ip 127.0.0.1
		String user = "jspexam";	// 사용자 이름	"계정"
		String password = "m1234";	// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);	// Driver 관리 함수, (접속, 연결 시도하는 class)
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			//e.printStackTrace();
		}
		return conn;	// 연결하는 커넥션
	}
	// 3. SQL 작업처리
	public void insertArticle() {

		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		// DB 처리
		// 4. 변환되는 결과는 int 변수에 담는다.
		Connection conn = getConnection();	// 연결
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";	
		// PreparedStatement '?' 를 사용하여 sql 문을 완성 시킴 
		// ? : 물음표의 순서는 1, 2, 3, 4 ...... 
		
//		String sql1 = "insert into dbtest values (" 
//						+ name + ", "  + age + ", " + height +", sysdate)";
		

		try {
			// conn 접속하기 위해.. conn 을 가져와서, prepareStatement로 데이터 삽입 >>> oracle 로
			pstmt = conn.prepareStatement(sql);		// PreparedStatement 객체 생성
			// 위 내용은 준비... 아래 것들로 삽입 시킴.. >> oracle에 명령을 줌.
			pstmt.setString(1,  name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			su = pstmt.executeUpdate();				// 실행 => 처리된 결과 개수가 리턴됨
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 최종적으로 닫아줘야 함.
				// 5. 접속을 종료한다.
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(su + "개의 행이 만들어졌습니다.");
	}
}

public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}
}

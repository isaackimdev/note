package com.dao;

public class Exam1 {
	public static void main(String[] args) {
		try {			// OracleDriver 클래스의 존재 유무 검사
						// 없으면 예외 발생, 즉 등록되어 있지 않으면 예외 발생
			Class.forName("oracle.jdbc.driver.OracleDriver");	// Package 내 class 이름
			// 검사만 하는 것.
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			e.printStackTrace();
		}
		
	}
}

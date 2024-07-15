package test.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory3 {
	private static SqlSessionFactory factory = null;
	
	// static 초기화
	static {
		try {
			String resource = "mybatis-config.xml";	// 파일 읽어와야 함
			
			// 문자열로 파일 읽어오기 클래스
			Reader reader = Resources.getResourceAsReader(resource);	// 파일을 열어서 읽어올 준비를 쫙 끝냄
			factory = new SqlSessionFactoryBuilder().build(reader);	// 읽어서 > factory에 초기화 시킴 /여기서 sql도 전부 검사함
			// 사용할 준비 함 ( 마이바티스 세팅이 여기서 됨 )
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 사용하기 위한 메서드
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
	
	
}

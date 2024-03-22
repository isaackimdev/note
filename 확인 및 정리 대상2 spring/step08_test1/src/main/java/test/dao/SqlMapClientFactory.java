package test.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory {
	// 마이바티스를 이용할 수 있도록 sql세션 팩토리를 생성
	private static SqlSessionFactory factory = null;
	// static 초기화
	
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);	//IO클래스
			factory = new SqlSessionFactoryBuilder().build(reader);		// 얘가 있어야 마이바티스 사용가능
			// 마이바티스 설정 >> 초기화 작업
			System.out.println("초기화 작동 OK");
		} catch(IOException e) {
			System.out.println("마이바티스 설정 오류");
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}

// Spring은 설정으로 시작해서 시작으로 끝남
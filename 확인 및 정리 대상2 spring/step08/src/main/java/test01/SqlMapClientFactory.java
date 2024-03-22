package test01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory {
	private static SqlSessionFactory factory = null;	// 얘가 있어야지만 mybatis를 사용할 수 있음
	// static 초기화
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);	// IO클래스
			factory = new SqlSessionFactoryBuilder().build(reader);		// 얘가 있어야지만 mybatis를 사용할 수 있음
			// mybatis 설정 >> 초기화 작업
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}

// Spring은 설정으로 시작해서 시작으로 끝남..

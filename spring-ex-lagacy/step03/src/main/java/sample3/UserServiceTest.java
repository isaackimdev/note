package sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceTest {
	public static void main(String[] args) {
		System.out.println("--- Container 초기화 시작 ---");
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample3/applicationContext.xml");	// 객체를 만들어서 관리하는 클래스 : Container : tomcat
		System.out.println("--- Container 초기화 완료 ---");
		
		UserService u1 = (UserService) context.getBean("userService");
		UserService u2 = new UserServiceImpl();
		UserVo vo = new UserVo("강호동");
		u1.addUser(vo);
		u2.addUser(vo);
		System.out.println("u1 = " + u1);
		System.out.println("-----------------------------------");
		
		UserService u3 = context.getBean("userService", UserService.class);
		UserVo vo2 = new UserVo("이순신");
		u3.addUser(vo2);
		System.out.println("u3 = " + u3);
		
		context.close();
	}
}

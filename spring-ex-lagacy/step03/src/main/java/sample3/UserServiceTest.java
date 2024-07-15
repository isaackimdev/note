package sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample3/applicationContext.xml");	// 객체를 만들어서 관리하는 클래스 : Container : tomcat
		
		UserService u1 = (UserService) context.getBean("userService");
		UserService u2 = new UserServiceImpl();
		UserVo vo = new UserVo("강호동");
		u1.addUser(vo);
		u2.addUser(vo);
		
		UserService u3 = context.getBean("userService", UserService.class);
		UserVo vo2 = new UserVo("이순신");
		u3.addUser(vo2);
		
		context.close();
	}
}

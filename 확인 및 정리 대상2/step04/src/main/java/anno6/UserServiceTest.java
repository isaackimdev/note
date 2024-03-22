package anno6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.scan("anno6");
		context.refresh();
		
		UserServiceImpl user = context.getBean("myTest", UserServiceImpl.class);
		user.show();
		
		context.close();
		
	}
}

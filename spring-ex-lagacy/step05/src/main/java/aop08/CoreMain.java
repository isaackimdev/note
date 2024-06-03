package aop08;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CoreMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop08/applicationContext.xml");
		CoreEx ex = context.getBean("core", CoreEx.class);
		ex.zeroMethod(5, 2);
		System.out.println("----------------------");
		ex.zeroMethod(5, 0);
		
		context.close();
		
		
	}
}

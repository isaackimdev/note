package aop07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop07/applicationContext.xml");
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		
		context.close();
	}
}

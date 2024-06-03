package sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("sample6/applicationContext.xml");
		
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.helloCall();
		
		context.close();
	}
}

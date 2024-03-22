package sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. bean.xml 설정 정보를 이용해서 bean 객체를 생성한다.
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample1/bean.xml");
		System.out.println("** Container 초기화 작업 **");
		// 2. bean 객체를 제공한다.
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		bean.sayHello("banana", 5500);
		
		context.close();
	}
}

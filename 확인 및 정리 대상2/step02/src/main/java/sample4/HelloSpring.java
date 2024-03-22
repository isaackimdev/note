package sample4;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		// 스프링을 이용한 접근
		// 1. bean.xml에 정의한 <bean> 설정 정보를 읽어와 내부적으로 
		// MessageBean 객체를 생성하고 초기화 한다.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/bean.xml");
		// 2. Bean객체를 검색하고, MessageBean 객체를 리턴한다.
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		
		context.close();
	}

}










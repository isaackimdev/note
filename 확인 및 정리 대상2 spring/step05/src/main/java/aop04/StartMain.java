package aop04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop04/applicationContext.xml");
		Person myPerson = (Person) context.getBean("woman");
		// my.classwork()가 실행되면,
		// Aspect 클래스에 정의된, before() 메소드 실행
		myPerson.classWork();
		// Aspect 클래스에 정의된, after() 메소드 실행
		context.close();
		
	}
}

package aop03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop03/applicationContext.xml");
		Person myPerson = (Person) context.getBean("man");
		// my.classwork()가 실해되면,
		// Aspect 클래스에 정의된, before() 메소드 실행
		myPerson.classWork();	// 대상 메서드 실행
		// Aspect 클래스에 정의된, after() 메서드 실행
		//Man man = (Man) myPerson;
		myPerson.test();
		
		Boy boy = (Boy) context.getBean("boy");
		boy.testBoy();
		
		context.close();
	}
}

package aop02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop02/applicationContext.xml");
		Boy boy = (Boy) context.getBean("boy");
		boy.testBoy(); // 상속관계에서는 부모클래스로 해줘야 한다...
		
		Person myPerson = (Person) context.getBean("man");
		// my.classwork()가 실행되면,
		// Aspect 클래스에 정의된, 대상 메서드 실행전 코드 실행
		myPerson.classWork();
		myPerson.test();
		
		// Aspect 클래스에 정의된, 대상 메서드 실행후 코드 실행
		System.out.println("------------------------");
		myPerson = (Person) context.getBean("woman");
		myPerson.classWork();
		
		context.close();
	}
}

package aop06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop06/applicationContext.xml");
		Person myPerson = (Person) context.getBean("woman");
		myPerson.classWork();
		
		System.out.println();
		myPerson = (Person) context.getBean("man");
		myPerson.classWork();
	
		context.close();
		
	}
}

package aop05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("aop05/applicationContext.xml");
		Person myPerson = (Person) context.getBean("woman");
		myPerson.classWork();
		
		myPerson = (Person) context.getBean("man");
		myPerson.classWork();
	
		context.close();
		
	}
}

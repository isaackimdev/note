package sample8;

import org.springframework.context.support.GenericXmlApplicationContext;

import sample8.Emp;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample8/applicationContext2.xml");
		
		Developer developer = (Developer) context.getBean("developer");
		System.out.println(developer.toString());
		
		Engineer engineer = (Engineer) context.getBean("engineer");
		System.out.println(engineer.toString());
		
		context.close();
	}
}

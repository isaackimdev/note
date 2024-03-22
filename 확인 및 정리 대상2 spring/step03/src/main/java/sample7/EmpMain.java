package sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		
	
	
	GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("sample7/applicationContext.xml");
	Emp b1 = (Emp) context.getBean("developer");
	System.out.println(b1.toString());
	
	Emp b2 = (Emp) context.getBean("engineer");
	System.out.println(b2.toString());
	
	context.close();
	}
}

package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/applicationContext.xml");
		AbstractTest test = (AbstractTest) context.getBean("test");
		System.out.println("오늘은" + test.dayInfo());
		System.out.println("test = " + test);

		AbstractTest test2 = (AbstractTest) context.getBean("test");
		System.out.println("오늘은" + test2.dayInfo());
		System.out.println("test = " + test2);
		
		context.close();
	}
}

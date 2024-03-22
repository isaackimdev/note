package sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BirthdayEx {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext("sample5/applicationContext.xml");
		DateVo hong = (DateVo) context.getBean("hong");
		System.out.println(hong.toString());
		
		DateVo lee = (DateVo) context.getBean("lee");
		System.out.println(lee.toString());
		
		context.close();
	}
}

package test3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext("test3/applicationContext.xml");
		
		Calc bean;
		bean = (Calc) context.getBean("calcAdd");
		bean.calculate();
		
		bean = (Calc) context.getBean("calcMul");
		bean.calculate();
		
		context.close();
	}
}








